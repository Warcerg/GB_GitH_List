package com.example.gb_gith_list.model.entities


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val id: Long,
    val login: String,
    val avatar: String,
    val fullName: String
) : Parcelable {
}
