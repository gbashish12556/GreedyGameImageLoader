package com.example.greedygameimagecachinglibrary.network

import com.example.greedygameimagecachinglibrary.pojo.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("r/images/hot.json")
    fun getAllResponse(): Call<Response>

}