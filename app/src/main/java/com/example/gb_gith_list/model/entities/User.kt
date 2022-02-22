package com.example.gb_gith_list.model.entities


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    @field:SerializedName("login")  val login: String = "",
    @field:SerializedName("avatar_url") val avatar: String = "",
    @field:SerializedName("name") val fullName: String = ""
) : Parcelable {

    companion object{
        fun getDefaultUsers() = listOf<String>("Warcerg", "borhammere", "kirich1409", "defunkt")
    }
}


