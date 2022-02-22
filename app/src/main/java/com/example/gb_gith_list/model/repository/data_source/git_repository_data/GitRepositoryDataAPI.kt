package com.example.gb_gith_list.model.repository.data_source.git_repository_data

import com.example.gb_gith_list.model.entities.User
import com.example.gb_gith_list.model.entities.UserRepository
import com.example.gb_gith_list.model.repository.data_source.recieved_entities.UserDTO
import com.example.gb_gith_list.model.repository.data_source.recieved_entities.UserRepositoryDTO
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitRepositoryDataAPI {

    @GET("users/{username}/repos")
    fun getUserRepoList(
        @Path("username") username: String
    ): Observable<List<UserRepository>>


    @GET("users/{username}")
    fun getUserInfo(
        @Path("username") username: String
    ): Call<UserDTO>

}