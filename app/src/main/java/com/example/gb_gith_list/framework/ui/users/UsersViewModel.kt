package com.example.gb_gith_list.framework.ui.users

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gb_gith_list.framework.App
import com.example.gb_gith_list.model.AppState
import com.example.gb_gith_list.model.repository.Repository

class UsersViewModel(private val repository: Repository): ViewModel(), LifecycleObserver {
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val SLEEPVALUE: Long = 500


    fun getLiveData() = liveDataToObserve

    fun getUsersData() =
        getUsersDataFromLocal()

    private fun getUsersDataFromLocal() {
/*        liveDataToObserve.value = AppState.Loading*/
        Thread {
            Thread.sleep(SLEEPVALUE)
            liveDataToObserve.postValue(AppState.Success(repository.getUsers()))
        }.start()
    }

}