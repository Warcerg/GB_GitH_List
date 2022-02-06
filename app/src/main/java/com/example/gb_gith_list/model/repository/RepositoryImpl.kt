package com.example.gb_gith_list.model.repository

import com.example.gb_gith_list.model.entities.User
import com.example.gb_gith_list.model.entities.UserRepository
import com.example.gb_gith_list.model.repository.data_source.git_repository_data.GitRepositoryDataRepo

class RepositoryImpl: Repository {


    override fun getUsers(): List<User> {
        val usersList = mutableListOf<User>()
        for (i in 1..5){
            usersList.add(
                User(
                    login = "warcerg",
                    avatar = "https://avatars.githubusercontent.com/u/81096228?v=4",
                    fullName = "Andrey Efremov"
                )
            )
        }
        return usersList.toList()
    }

    override fun getUserRepoList(user: User): List<UserRepository> {
        val dto = GitRepositoryDataRepo.API.getUserRepoList(user.login).execute().body()
        val repoList = mutableListOf<UserRepository>()
        if ( dto?.size!= null){
            for(i in dto.indices){
                repoList.add(
                    UserRepository(
                        repositoryName = dto[i].repositoryName ?: "",
                        repositoryDescription = dto[i].repositoryDescription ?: "",
                        language = dto[i].language ?: ""
                    )
                )
            }

        }
        return repoList.toList()
    }
}