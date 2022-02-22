package com.example.gb_gith_list.framework.ui.users

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gb_gith_list.model.AppState
import com.example.gb_gith_list.model.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class UsersViewModel(private val repository: Repository): ViewModel(), LifecycleObserver {
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private lateinit var disposable: Disposable


    fun getLiveData() = liveDataToObserve

    fun getUsersData() =
        getUsersDataFromServer()


    private fun getUsersDataFromServer() {
        liveDataToObserve.value = AppState.Loading
        disposable = repository.userListSingle
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { userList ->  liveDataToObserve.postValue(AppState.SuccessUsersList(userList)) }
    }

    override fun onCleared() {
        disposable.dispose()
    }

}