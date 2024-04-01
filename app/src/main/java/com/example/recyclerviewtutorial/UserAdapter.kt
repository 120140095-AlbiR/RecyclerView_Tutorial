package com.example.recyclerviewtutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewtutorial.databinding.ItemUserBinding


class UserAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder constructor (val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User) {
            binding.txtName.text = "${user.firstName} ${user.lastName}"
            binding.txtEmail.text = user.email
            Glide.with(itemView)
                .load(user.avatar)
                .into(binding.imgAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            UserViewHolder {
        return UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int)
    {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}