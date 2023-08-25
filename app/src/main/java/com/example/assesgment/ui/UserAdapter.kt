package com.example.assesgment.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assesgment.model.User
import com.example.assesgment.model.UserRespond

class UserAdapter(private val userList: List<User>, private val context: Context) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]

        holder.binding.apply {
            var tvTitle = null
            tvTitle.text = user.title.toString()
            tvName.text = user.name.toString()
            tvId.text = user.id.toString()
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)
}
class Adapter (var postResponse:List<PostsModel>,var context: Context):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding = PostresponseBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var posts = postResponse.get(position)
        var binding = holder.binding
        binding.tvUserId.text=posts.toString()
        binding.tvTitle.text = posts.title
        binding.tvBody.text = posts.body

        holder.binding.tvUserId.setOnClickListener {
            val intent = Intent(context,UserRespond::class.java)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return postResponse.size
    }
}
class PostViewHolder(var binding: PostresponseBinding):RecyclerView.ViewHolder(binding.root)