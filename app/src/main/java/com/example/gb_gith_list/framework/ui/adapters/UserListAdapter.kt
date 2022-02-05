package com.example.gb_gith_list.framework.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.gb_gith_list.databinding.UsersListRecyclerFragmentBinding
import com.example.gb_gith_list.model.entities.User

class UserListAdapter(private var userListData: List<User>) : RecyclerView.Adapter<UserListAdapter.MainViewHolder>() {
    private lateinit var binding: UsersListRecyclerFragmentBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = UsersListRecyclerFragmentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(userListData[position])
    }

    override fun getItemCount(): Int {
       return userListData.size
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(user: User) = with(binding) {
            userName.text = user.login
            userAvatar.load(user.avatar)
        }
    }
}


