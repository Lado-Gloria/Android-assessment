package com.example.assesgment.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assesgment.R
import com.example.assesgment.api.ApiClient
import com.example.assesgment.api.ApiInterface
import com.example.assesgment.databinding.ActivityMainBinding
import com.example.assesgment.databinding.ActivityUserAdapterBinding
import com.example.assesgment.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserAdapterBinding
    private lateinit var apiinterface: ApiInterface
    private var userId = -1
    private var user: User? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        apiinterface = ApiClient.buildClient(ApiInterface::class.java)
        val bundle = intent.extras
        if (bundle != null) {
            userId = bundle.getInt("USER_ID", -1)
        }
        fetchUserDetails()
    }


    private fun fetchUserDetails() {
        GlobalScope.launch(Dispatchers.Main) {
            // Make the API call to fetch product details using 'productId'
            val response = apiinterface.getUserById(userId)

            if (response.isSuccessful) {
                // API call successful, retrieve product details from the response
                user = response.body()

                // Display product details in the UI
                runOnUiThread {
                    displayUserDetails()
                }
            } else {
                runOnUiThread {
                    Toast.makeText(
                        this@UserDetailActivity,
                        "Failed to fetch product details",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun displayUserDetails() {
        // Check if product is not null and display its details in the UI
        user?.let {

        }
    }
}
