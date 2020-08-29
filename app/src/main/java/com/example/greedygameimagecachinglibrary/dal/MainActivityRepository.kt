package com.example.greedygameimagecachinglibrary.dal

import androidx.lifecycle.MutableLiveData
import com.example.greedygameimagecachinglibrary.network.Resource
import com.example.greedygameimagecachinglibrary.network.RetrofitClient
import com.example.greedygameimagecachinglibrary.pojo.AllImageResponse
import com.example.greedygameimagecachinglibrary.pojo.CompleteImageData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivityRepository {

    private var allData = MutableLiveData<Resource<List<CompleteImageData>>>()

    fun getAllImageResponse(): MutableLiveData<Resource<List<CompleteImageData>>> {
        fetchData()
        return allData
    }

    fun fetchData() {

        val call1 = RetrofitClient.instance.api.getAllResponse()

        call1.enqueue(object : Callback<AllImageResponse> {

            override fun onResponse(
                call: Call<AllImageResponse>,
                response: Response<AllImageResponse>
            ) {

                if (response.code() == 200) {
                    val reponse = response.body()
                    if (reponse!!.data.children.size > 0) {
                        allData.postValue(Resource.error("Success",reponse!!.data.children))
                    } else {
                        allData.postValue(Resource.error("Failed",null))
                    }
                } else {
                    allData.postValue(Resource.error("Failed",null))
                }
            }

            override fun onFailure(call: Call<AllImageResponse>, t: Throwable) {
                allData.postValue(Resource.error("Failed",null))
            }

        })

    }
}