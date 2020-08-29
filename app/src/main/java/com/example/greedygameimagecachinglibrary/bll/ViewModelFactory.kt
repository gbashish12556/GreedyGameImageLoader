package com.example.greedygameimagecachinglibrary.bll

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.greedygameimagecachinglibrary.dal.MainActivityRepository

class ViewModelFactory(private val mainActivityRepository: MainActivityRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(mainActivityRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}