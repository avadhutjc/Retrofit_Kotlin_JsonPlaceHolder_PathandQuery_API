package com.ajc.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    //https://jsonplaceholder.typicode.com/comments?postId=1


//    @GET("/api/users")
//    fun getPosts(@Query("ID") Id: Int): Call<ResponseDTO>

    @GET("/comments")
    fun getPosts(@Query("postId") Id: Int) : Call<List<ResponseDTOItem>>


//    @GET("/comments")
//    fun getPost(@Query("postId") A: Int) : Call<ResponseDTO>
}