package com.example.imageloader

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

class ImageRecyclerView : RecyclerView, AdapterView.OnItemClickListener {

    constructor(context: Context, attributeSet: AttributeSet? = null) : super(context, attributeSet)

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }


}