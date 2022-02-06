package com.example.gb_gith_list.model.repository.data_source.git_repository_data

import com.example.gb_gith_list.model.repository.data_source.ApiUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitRepositoryDataRepo {

    val API: GitRepositoryDataAPI by lazy {
        val adapter = Retrofit.Builder()
            .baseUrl(ApiUtils.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(ApiUtils.getOkHTTPBuilder())
            .build()

        adapter.create(GitRepositoryDataAPI::class.java)
    }

}