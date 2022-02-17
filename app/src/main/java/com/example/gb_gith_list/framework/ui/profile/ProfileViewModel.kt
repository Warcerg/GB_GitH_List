package com.example.gb_gith_list.framework.ui.profile

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gb_gith_list.model.AppState
import com.example.gb_gith_list.model.entities.User
import com.example.gb_gith_list.model.repository.Repository
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ProfileViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private lateinit var disposable: Disposable


    fun getLiveData() = liveDataToObserve

    fun getUserRepoListData(user: User) {
        getRepoListDataFromServer(user)

    }

    private fun getRepoListDataFromServer(user: User) {
        liveDataToObserve.value = AppState.Loading
        disposable = repository.getSingleUserRepoList(user)
            .observeOn(Schedulers.io())
            .subscribe { repoList -> liveDataToObserve.postValue(AppState.SuccessUserRepoList(repoList)) }
    }


    override fun onCleared() {
        disposable.dispose()
    }

}