package com.example.greedygameimagecachinglibrary.adapter

import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import com.example.greedygameimagecachinglibrary.pojo.CompleteImageData
import com.example.imageloader.adapter.ImageAdapter
import com.example.imageloader.component.ImageItemView

class ImageGridAdapter : ImageAdapter<CompleteImageData, ImageItemView> {
    override fun getView(data: CompleteImageData, parent: ViewGroup): ImageItemView {
        val view = ImageItemView(parent.context)

        return view
    }

    override fun bindView(data: CompleteImageData, view: View, position: Int) {
        super.bindView(data, view, position)
        val episodeItemView = (view as ImageItemView)

//        Glide.with(view.context).load(data.posterUrl.let { Uri.parse(it) }
//            ?: "").into(object : ViewTarget<ImageItemView, Drawable>(view) {
//            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
//                resource.let { drawable ->
//                    episodeItemView.setImageDrawable(drawable)
//                }
//            }
//        })

    }

}