package com.example.gb_gith_list.model.repository.data_source.recieved_entities

import com.google.gson.annotations.SerializedName

data class UserRepositoryDTO(
    @field:SerializedName("name") val repositoryName: String?,
    @field:SerializedName("description") val repositoryDescription: String?,
    @field:SerializedName("language") val language: String?
)