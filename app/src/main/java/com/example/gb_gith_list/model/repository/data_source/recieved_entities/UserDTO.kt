package com.example.gb_gith_list.model.repository.data_source.recieved_entities

import com.google.gson.annotations.SerializedName

data class UserDTO(
    @field:SerializedName("login") val login: String?,
    @field:SerializedName("avatar_url") val avatar: String?,
    @field:SerializedName("name") val fullName: String?
)