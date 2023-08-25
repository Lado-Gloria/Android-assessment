package com.example.assesgment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assesgment.api.ApiClient
import com.example.assesgment.api.ApiInterface
import com.example.assesgment.databinding.ActivityMainBinding
import com.example.assesgment.model.UserRespond
import com.example.assesgment.viewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class MainActivity(private val userViewModel: UserViewModel) : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
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

        getResponse()
    }

    private fun getResponse() {
        val retrofit = ApiClient.buildClient(ApiInterface::class.java)
        val request = retrofit.getUser()
        request.apply(object : Callback<List<UserRespond>> {
            override fun onResponse(
                call: Call<List<UserRespond>>,
                response: Response<List<UserRespond>>
            ) {
                if (response.isSuccessful) {
                    val postings = response.body()
                    Toast.makeText(baseContext, "${postings?.size} postings", Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<List<UserRespond>>, t: Throwable) {
                // Handle failure if needed
            }
        })
    }
}

private fun Unit.apply(block: Callback<List<UserRespond>>) {

}
