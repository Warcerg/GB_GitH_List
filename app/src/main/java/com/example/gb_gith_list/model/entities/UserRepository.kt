package com.example.gb_gith_list.model.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserRepository(
    @field:SerializedName("name") val repositoryName: String,
    @field:SerializedName("description") val repositoryDescription: String,
    @field:SerializedName("language") val language: String
): Parcelable {
}