package com.example.gb_gith_list.framework.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.api.load
import com.example.gb_gith_list.databinding.ProfileFragmentBinding
import com.example.gb_gith_list.databinding.UsersFragmentBinding
import com.example.gb_gith_list.framework.App
import com.example.gb_gith_list.framework.ui.ViewModelFactory
import com.example.gb_gith_list.framework.ui.adapters.RepoListAdapter
import com.example.gb_gith_list.framework.ui.adapters.UserListAdapter
import com.example.gb_gith_list.framework.ui.users.UsersViewModel
import com.example.gb_gith_list.model.AppState
import com.example.gb_gith_list.model.entities.User


class ProfileFragment: Fragment() {
    private val viewBinding: ProfileFragmentBinding by viewBinding(createMethod = CreateMethod.INFLATE)

    private lateinit var viewModel: ProfileViewModel
    private var adapter : RepoListAdapter? = null

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
           recyclerViewRepositoryList.adapter = adapter
            val user = arguments?.getParcelable<User>(BUNDLE_EXTRA)
            user?.let {
                renderData(user)

            }
        }
    }

    private fun renderData(user: User) = with(viewBinding) {
        userAvatar.load(user.avatar)
        userLogin.text = user.login
        userName.text = user.fullName
        viewModel.getUserRepoListData(user)
        viewModel.getLiveData().observe(viewLifecycleOwner, { appState ->
            when (appState) {
                is AppState.Error -> {}
                is AppState.Loading -> {}
                is AppState.SuccessUserRepoList -> {
                    adapter = RepoListAdapter(appState.repoList)
                    recyclerViewRepositoryList.adapter = adapter
                }
            }
        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(App.instance.repository)).get(
           ProfileViewModel::class.java)
    }

    companion object {
        const val BUNDLE_EXTRA = "profile data"

        fun newInstance(bundle: Bundle): ProfileFragment {
            val fragment = ProfileFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}