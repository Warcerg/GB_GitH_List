package com.example.gb_gith_list.model.repository

import com.example.gb_gith_list.model.entities.User
import com.example.gb_gith_list.model.entities.UserRepository
import com.example.gb_gith_list.model.repository.data_source.git_repository_data.GitRepositoryDataRepo
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

class RepositoryImpl: Repository {


    override fun getUsers(): List<User> {
        val usersList = mutableListOf<User>()
        val userLogins = User.getDefaultUsers()
        for (user in userLogins) {
            val dto = GitRepositoryDataRepo.API.getUserInfo(user).execute().body()
            usersList.add(
                User(
                    login = dto?.login ?: "",
                    avatar = dto?.avatar ?: "",
                    fullName = dto?.fullName ?: ""
                )
            )
        }
        return usersList.toList()
    }

    override fun getUserRepoList(user: User): List<UserRepository> {
        val dto = GitRepositoryDataRepo.API.getUserRepoList(user.login).execute().body()
        val repoList = mutableListOf<UserRepository>()
        if ( dto?.size!= null){
            for(i in dto.indices){
                repoList.add(
                    UserRepository(
                        repositoryName = dto[i].repositoryName ?: "",
                        repositoryDescription = dto[i].repositoryDescription ?: "",
                        language = dto[i].language ?: ""
                    )
                )
            }

        }
        return repoList.toList()
    }

    override val userListSingle: Single<List<User>>
        get() = Single.timer(3, TimeUnit.SECONDS).map {
            val usersList = mutableListOf<User>()
            val userLogins = User.getDefaultUsers()
            for (user in userLogins) {
                val dto = GitRepositoryDataRepo.API.getUserInfo(user).execute().body()
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


    override fun getSingleUserRepoList(user: User): Single<List<UserRepository>> {
        return Single.timer(1, TimeUnit.SECONDS).map {
            val dto = GitRepositoryDataRepo.API.getUserRepoList(user.login).execute().body()
            val repoList = mutableListOf<UserRepository>()
            if (dto?.size != null) {
                for (i in dto.indices) {
                    repoList.add(
                        UserRepository(
                            repositoryName = dto[i].repositoryName ?: "",
                            repositoryDescription = dto[i].repositoryDescription ?: "",
                            language = dto[i].language ?: ""
                        )
                    )
                }
            }
            return@map repoList.toList()
        }
    }


}