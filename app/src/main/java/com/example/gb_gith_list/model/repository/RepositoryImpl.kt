package com.example.gb_gith_list.model.repository

import com.example.gb_gith_list.model.entities.User
import com.example.gb_gith_list.model.entities.UserRepository
import com.example.gb_gith_list.model.repository.data_source.git_repository_data.GitRepositoryDataRepo

class RepositoryImpl: Repository {


    override fun getUsers(): List<User> {
        val usersList = mutableListOf<User>()
        val userLogins = User.getDefaultUsers()
        for (user in userLogins) {
            val dto = GitRepositoryDataRepo.API.getUserInfo(user).execute().body()
            usersList.add(
                User(
                    login = dto?.login ?: "",
                    avatar = dto?.avatar ?: "",
                    fullName = dto?.fullName ?: ""
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