package com.example.greedygameimagecachinglibrary.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.greedygameimagecachinglibrary.R
import com.example.greedygameimagecachinglibrary.bll.MainActivityViewModel
import com.example.greedygameimagecachinglibrary.bll.ViewModelFactory
import com.example.greedygameimagecachinglibrary.dal.MainActivityRepository

class MainActivity : AppCompatActivity() {

    private var invitationViewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun setupUI() {

    }


    private fun setupViewModel() {
        invitationViewModel = ViewModelProviders.of(this, ViewModelFactory(
            MainActivityRepository()
        )
        ).get(MainActivityViewModel::class.java)
    }
}

