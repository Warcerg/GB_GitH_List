package com.example.gb_gith_list.framework

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.gb_gith_list.model.repository.Repository
import com.example.gb_gith_list.model.repository.RepositoryImpl

class App : Application()  {

    val repository: Repository by lazy { RepositoryImpl() }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    val Context.app: App
        get() = applicationContext as App

    val Fragment.app: App
        get() = requireActivity().app


    companion object {
        lateinit var instance: App
    }
}

