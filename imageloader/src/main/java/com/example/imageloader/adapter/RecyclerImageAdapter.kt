package com.example.imageloader.adapter

import android.view.ViewGroup
import com.example.imageloader.component.ImageViewItem
import com.example.imageloader.model.ImageResourceModel
import com.example.imageloader.model.ObservableView

class RecyclerImageAdapter : ImageAdapter<ImageResourceModel, ObservableView<ImageViewItem>> {
    override fun getView(data: ImageResourceModel, parent: ViewGroup): ObservableView<ImageViewItem> {
        val imageView = ImageViewItem(parent.context)
        imageView.setImageResource(data.get().resource)
        return imageView
    }
}