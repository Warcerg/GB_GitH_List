package com.example.gb_gith_list.model

import com.example.gb_gith_list.model.entities.User

sealed class AppState {
    object Loading: AppState()
    data class Success(val users: List<User>) : AppState()
    data class Error(val error: Throwable) : AppState()
}
