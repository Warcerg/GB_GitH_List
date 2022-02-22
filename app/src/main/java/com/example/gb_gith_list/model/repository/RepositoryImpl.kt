package com.example.gb_gith_list.model.repository

import com.example.gb_gith_list.model.entities.User
import com.example.gb_gith_list.model.entities.UserRepository
import com.example.gb_gith_list.model.repository.data_source.ApiUtils
import com.example.gb_gith_list.model.repository.data_source.git_repository_data.GitRepositoryDataAPI
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RepositoryImpl : Repository {

    private val retrofit = Retrofit.Builder()
        .baseUrl(ApiUtils.getBaseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(ApiUtils.getOkHTTPBuilder())
        .build()

    private val api: GitRepositoryDataAPI = retrofit.create(GitRepositoryDataAPI::class.java)

    override val userListSingle: Single<List<User>>
        get() = Single.timer(3, TimeUnit.SECONDS).map {
            val usersList = mutableListOf<User>()
            val userLogins = User.getDefaultUsers()
            for (user in userLogins) {
                val dto = api.getUserInfo(user).execute().body()
                usersList.add(
                    User(
                        login = dto?.login ?: "",
                        avatar = dto?.avatar ?: "",
                        fullName = dto?.fullName ?: ""
                    )
                )
            }
            return@map usersList.toList()
        }

    override fun getSingleUserRepoList(user: User): Observable<List<UserRepository>> =
        api.getUserRepoList(user.login)


}