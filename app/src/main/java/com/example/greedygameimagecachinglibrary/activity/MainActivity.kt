package com.example.greedygameimagecachinglibrary.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.greedygameimagecachinglibrary.R
import com.example.greedygameimagecachinglibrary.adapter.ImageGridAdapter
import com.example.greedygameimagecachinglibrary.bll.MainActivityViewModel
import com.example.greedygameimagecachinglibrary.bll.ViewModelFactory
import com.example.greedygameimagecachinglibrary.dal.MainActivityRepository
import com.example.greedygameimagecachinglibrary.pojo.CompleteImageData
import com.example.imageloader.adapter.ImageAdapter
import com.example.imageloader.component.ImageGridView
import com.example.imageloader.model.ResourceData
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {

    private var invitationViewModel: MainActivityViewModel? = null
    private val images: ArrayList<ResourceData<CompleteImageData>> = ArrayList()
    private var gridView: ImageGridView? = null
    private var disposable:Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gridView = findViewById(R.id.imageGridView)
        setupViewModel()
        setupUI()
    }

    private fun setupUI() {
        invitationViewModel?.getAllImageResponse()?.observe(this, Observer {
            Log.d("dataSize",it.data?.size.toString())
            images.addAll(it.data!!)
            val adapter = ImageGridAdapter()
            gridView?.setGridItemWidth(260)
            gridView?.gridResourceDataAdapter = adapter as ImageAdapter<Any, *>
            gridView?.gridData = it.data?.toList() as List<ResourceData<Any>>
            disposable = gridView?.onSelectObservable?.subscribe { episode ->
                launchNextScreen(episode)
            }
        })
    }


    private fun launchNextScreen(episode:ResourceData<Any>){

    }
    private fun setupViewModel() {
        invitationViewModel = ViewModelProviders.of(this, ViewModelFactory(
            MainActivityRepository()
        )
        ).get(MainActivityViewModel::class.java)
    }
}

