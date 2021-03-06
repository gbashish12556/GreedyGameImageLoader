package com.example.greedygameimagecachinglibrary.adapter

import android.graphics.drawable.Drawable
import android.net.Uri
import android.transition.Transition
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.example.greedygameimagecachinglibrary.pojo.CompleteImageData
import com.example.imageloader.adapter.ImageAdapter
import com.example.imageloader.component.ImageItemView
import com.example.imageloader.utils.ImageLoader

class ImageGridAdapter : ImageAdapter<CompleteImageData, ImageItemView> {
    override fun getView(data: CompleteImageData, parent: ViewGroup): ImageItemView {
        val view = ImageItemView(parent.context)

        return view
    }

    override fun bindView(data: CompleteImageData, view: View, position: Int) {
        super.bindView(data, view, position)
        val episodeItemView = (view as ImageItemView)

        Log.d("imageUrl",data.data.preview.images[0].source.url)

        ImageLoader.with(view.context).load(episodeItemView.getImageView(), data.data.url_overridden_by_dest)

    }

}