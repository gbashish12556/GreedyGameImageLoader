package com.example.greedygameimagecachinglibrary.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.greedygameimagecachinglibrary.R
import com.example.imageloader.utils.ImageLoader

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var imageView  = findViewById<ImageView>(R.id.imageView)
        var argument = intent.extras
        if(argument != null) {
            ImageLoader.with(this)
            .load(imageView, argument.getString("imageUrl")!!)
        }
    }
}