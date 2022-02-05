package com.example.gb_gith_list.model.repository

import com.example.gb_gith_list.model.entities.User
import com.example.gb_gith_list.model.entities.UserRepository

class RepositoryImpl: Repository {
    override fun getUsers(): List<User> {
        val usersList = mutableListOf<User>()
        for (i in 1..5){
            usersList.add(
                User(
                    login = "warcerg",
                    id = 81096228,
                    avatar = "https://avatars.githubusercontent.com/u/81096228?v=4",
                    fullName = "Andrey Efremov"
                )
            )
        }
        return usersList.toList()
    }

    override fun getUserRepoList(user: User): List<UserRepository> {
        TODO("Not yet implemented")
    }
}