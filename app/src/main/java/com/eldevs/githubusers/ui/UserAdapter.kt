package com.eldevs.githubusers.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eldevs.githubusers.data.model.UserItem
import com.eldevs.githubusers.databinding.ItemUserBinding

class UserAdapter(private val onItemClick: (UserItem) -> Unit) : ListAdapter<UserItem, UserAdapter.UserViewHolder>(UserDiffCallback) {

    inner class UserViewHolder(var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.binding.apply {
            tvUserId.text = user.id.toString()
            tvUsername.text = user.login
            Glide.with(this.root.context).load(user.avatar_url).into(this.ivUserAvatar)
        }
        holder.itemView.setOnClickListener {
            onItemClick(user)
        }
    }

    object UserDiffCallback : DiffUtil.ItemCallback<UserItem>() {
        override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return oldItem.id == newItem.id
        }
    }
}