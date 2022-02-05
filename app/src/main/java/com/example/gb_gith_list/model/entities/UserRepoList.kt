package com.example.gb_gith_list.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserRepoList(
    val id: Long,
    val login: String,
    val repoList: List<UserRepository> = emptyList()
): Parcelable
