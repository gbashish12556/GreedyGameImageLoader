package com.example.greedygameimagecachinglibrary.network

import com.example.greedygameimagecachinglibrary.pojo.AllImageResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("r/images/hot.json")
    fun getAllResponse(): Call<AllImageResponse>

}