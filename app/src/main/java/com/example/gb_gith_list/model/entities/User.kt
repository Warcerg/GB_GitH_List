package com.example.gb_gith_list.model.entities


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val login: String = "",
    val avatar: String = "",
    val fullName: String = ""
) : Parcelable {

    companion object{
        fun getDefaultUsers() = listOf<String>("Warcerg", "borhammere", "kirich1409", "defunkt")
    }
}


