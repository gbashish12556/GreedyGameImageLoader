package com.example.greedygameimagecachinglibrary.bll

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.greedygameimagecachinglibrary.dal.MainActivityRepository
import com.example.greedygameimagecachinglibrary.network.Resource
import com.example.greedygameimagecachinglibrary.pojo.CompleteImageData

class MainActivityViewModel(private val mainActivityRepository: MainActivityRepository) :ViewModel() {

    fun getAllImageResponse(): MutableLiveData<Resource<List<CompleteImageData>>> {
            return mainActivityRepository.getAllImageResponse()
    }

}
