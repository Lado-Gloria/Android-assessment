package com.example.assesgment.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assesgment.databinding.UseritemBinding
import com.example.assesgment.model.User


class UserAdapter(private val userList: List<User>, var context: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var binding = UseritemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]

        holder.binding.apply {
            tvbody.text = user.title.toString()
            tvName.text = user.name.toString()
            tvid.text = user.id.toString()
        }

        holder.binding.cvUser.setOnClickListener {
            val intent = Intent(context, UserDetailActivity::class.java)
            intent.putExtra("USER_ID", user.id)
            intent.putExtra("USER_TITLE", user.title)
            context.startActivities(arrayOf(intent))

        }
    }


    class UserViewHolder(var binding: UseritemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}