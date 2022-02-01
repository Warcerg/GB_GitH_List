package com.example.gb_gith_list.model.repository

import com.example.gb_gith_list.model.entities.User
import com.example.gb_gith_list.model.entities.UserRepository

interface Repository {
    fun getUsers(): List<User>
    fun getUserRepoList(user: User): List<UserRepository>
}