package com.example.greedygameimagecachinglibrary.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient private constructor() {
    private val retrofit: Retrofit

    val api: ApiService
        get() = retrofit.create(ApiService::class.java)

    init {


        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY


        var client = OkHttpClient.Builder().connectTimeout(100, TimeUnit.SECONDS).readTimeout(100, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()

        retrofit = Retrofit.Builder()
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    }

    companion object {

        val BASE_URL = "https://www.reddit.com/"
        private var mRetrofitInstance: RetrofitClient? = null

        val instance: RetrofitClient
            get() {

                if (mRetrofitInstance == null) {
                    synchronized(this) {
                        if (mRetrofitInstance == null) {
                            mRetrofitInstance = RetrofitClient()
                        }
                    }
                }

                return mRetrofitInstance!!

            }
    }
}