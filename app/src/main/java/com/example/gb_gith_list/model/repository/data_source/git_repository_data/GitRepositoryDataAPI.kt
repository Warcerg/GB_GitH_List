package com.example.gb_gith_list.model.repository.data_source.git_repository_data

import com.example.gb_gith_list.model.repository.data_source.recieved_entities.UserDTO
import com.example.gb_gith_list.model.repository.data_source.recieved_entities.UserRepositoryDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitRepositoryDataAPI {

    @GET("{username}/repos")
    fun getUserRepoList(
        @Path("username") username: String
    ): Call<List<UserRepositoryDTO>>

    @GET("{username}")
    fun getUserInfo(
        @Path("username") username: String
    ): Call<UserDTO>

}