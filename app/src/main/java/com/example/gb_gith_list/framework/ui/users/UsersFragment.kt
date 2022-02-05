package com.example.gb_gith_list.framework.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.gb_gith_list.databinding.UsersFragmentBinding
import com.example.gb_gith_list.framework.App
import com.example.gb_gith_list.framework.ui.ViewModelFactory
import com.example.gb_gith_list.framework.ui.adapters.UserListAdapter
import com.example.gb_gith_list.model.AppState
import com.example.gb_gith_list.model.repository.Repository

class UsersFragment: Fragment() {

    private val viewBinding: UsersFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)

    private lateinit var viewModel: UsersViewModel
    private var adapter : UserListAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        with(viewBinding){
            recyclerViewUsersList.adapter = adapter
            viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
            viewModel.getUsersData()
        }


    }

    private fun renderData(appState: AppState) = with(viewBinding) {
        when(appState) {
            is AppState.Error -> TODO()
            is AppState.Loading -> TODO()
            is AppState.Success -> {
                adapter = UserListAdapter(appState.users)
                recyclerViewUsersList.adapter = adapter
            }
        }

    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(App.instance.repository)).get(UsersViewModel::class.java)
    }


    companion object {
        fun newInstance() = UsersFragment()
    }
}