package com.example.imageloader.model

class ImageResourceModel(val resource: Int, val resourceName: String): ResourceData<ImageResourceModel> {
    override fun get(): ImageResourceModel {
        return this
    }
}
