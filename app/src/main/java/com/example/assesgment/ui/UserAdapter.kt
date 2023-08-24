package com.example.assesgment.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assesgment.R
import com.example.assesgment.model.User

class UserAdapter(val userList: List<User>,var context: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    @SuppressLint("SuspiciousIndentation")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        var binding=UseritemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        val product = userList[position]

        holder.binding.apply {
            tvdescriptions.text = product.description.toString()
            tvname.text = product.title.toString()
            tvprice.text = product.price.toString()

            Picasso
                .get()
                .load(product.thumbnail)
                .resize(100, 100)
                .into(holder.binding.ivProduct)


        }
        holder.binding.cvProducts.setOnClickListener {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("PRODUCT_ID", product.id)
            intent.putExtra("PRODUCT_TITLE", product.title)
            context.startActivities(arrayOf(intent))

        }
    }

        override fun getItemCount(): Int {
            return userList.size
        }

        class UserViewHolder(var binding: UseritemsBinding) :
            RecyclerView.ViewHolder(binding.root) {
        }
    }

























    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {



    }

}






