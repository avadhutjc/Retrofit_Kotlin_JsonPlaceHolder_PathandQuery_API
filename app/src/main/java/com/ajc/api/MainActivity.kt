package com.ajc.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var responseList: List<ResponseDTOItem> = listOf<ResponseDTOItem>() //emptylist

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPost.setOnClickListener {
            callAPI()
        }
    }

    private fun callAPI() {

        val apiClient = Network.getRetrofitInstance().create(ApiClient::class.java)
        apiClient.getPosts(etPostId.text.toString().toInt())
            .enqueue(object :Callback<List<ResponseDTOItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDTOItem>>,
                    response: Response<List<ResponseDTOItem>>
                ) {
                    responseList = response.body()!!
                    setRecyclerView()
                }

                override fun onFailure(call: Call<List<ResponseDTOItem>>, t: Throwable) {
                    Log.d("nalni",t.toString())
                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                }

            })
    }

    private fun setRecyclerView() {

        val postAdapter = PostAdapter(responseList)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.adapter = postAdapter
        recyclerView.layoutManager = linearLayoutManager
    }
}