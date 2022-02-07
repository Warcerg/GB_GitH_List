package com.example.gb_gith_list.framework.ui.profile

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gb_gith_list.model.AppState
import com.example.gb_gith_list.model.entities.User
import com.example.gb_gith_list.model.repository.Repository

class ProfileViewModel(private val repository: Repository): ViewModel(), LifecycleObserver {
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val SLEEPVALUE: Long = 500


    fun getLiveData() = liveDataToObserve

    fun getUserRepoListData(user: User) {
        getRepoListDataFromServer(user)
    }


    private fun getRepoListDataFromServer(user: User) {
        liveDataToObserve.value = AppState.Loading
        Thread {
            Thread.sleep(SLEEPVALUE)
            liveDataToObserve.postValue(AppState.SuccessUserRepoList(repository.getUserRepoList(user)))
        }.start()
    }

}