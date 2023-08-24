package com.example.assesgment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assesgment.databinding.ActivityMainBinding
import com.example.assesgment.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel.fetchProducts()

        userViewModel.errLiveData.observe(this, Observer { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
        })

        userViewModel.userLiveData.observe(this, Observer { userList ->
            binding.rvuser.layoutManager = GridLayoutManager(
                this@MainActivity,
                2
            )
            binding.rvuser.adapter = UserAdapter(userList, this)
        })
    }
}
