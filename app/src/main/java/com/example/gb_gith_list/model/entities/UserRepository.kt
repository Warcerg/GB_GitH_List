package com.example.gb_gith_list.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserRepository(
    val repositoryName: String,
    val repositoryDescription: String,
    val language: String
): Parcelable {
}