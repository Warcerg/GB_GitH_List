package com.example.gb_gith_list.model

import com.example.gb_gith_list.model.entities.User
import com.example.gb_gith_list.model.entities.UserRepository

sealed class AppState {
    object Loading: AppState()
    data class SuccessUsersList(val users: List<User>) : AppState()
    data class SuccessUserRepoList(val repoList: List<UserRepository>) : AppState()
    data class Error(val error: Throwable) : AppState()
}
