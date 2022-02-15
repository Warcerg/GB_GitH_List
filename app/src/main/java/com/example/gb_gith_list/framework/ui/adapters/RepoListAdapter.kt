package com.example.gb_gith_list.framework.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_gith_list.databinding.GitRepositoryRecyclerItemBinding
import com.example.gb_gith_list.model.entities.UserRepository

class RepoListAdapter(private var repoList: List<UserRepository>): RecyclerView.Adapter<RepoListAdapter.MainViewHolder>() {
    private lateinit var binding: GitRepositoryRecyclerItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListAdapter.MainViewHolder {
        binding = GitRepositoryRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(repoList[position])
    }


    override fun getItemCount(): Int {
        return repoList.size
    }


    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(repo: UserRepository) = with(binding) {
            repositoryName.text = repo.repositoryName
            repositoryDescription.text = repo.repositoryDescription
            repositoryLanguage.text = repo.language
        }
    }
}