package com.example.gb_gith_list.framework.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gb_gith_list.framework.ui.profile.ProfileViewModel
import com.example.gb_gith_list.framework.ui.users.UsersViewModel
import com.example.gb_gith_list.model.repository.Repository

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(UsersViewModel::class.java)) {
            return UsersViewModel(this.repository) as T
        }
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(this.repository) as T
        }
        throw IllegalArgumentException("ViewModel not found")
    }

}