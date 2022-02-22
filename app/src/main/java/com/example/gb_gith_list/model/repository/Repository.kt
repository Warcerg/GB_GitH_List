package com.example.gb_gith_list.model.repository

import com.example.gb_gith_list.model.entities.User
import com.example.gb_gith_list.model.entities.UserRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface Repository {
    val userListSingle: Single<List<User>>

    fun getSingleUserRepoList(user: User): Observable<List<UserRepository>>
}