package com.example.imageloader.adapter

import android.view.View
import android.view.ViewGroup
import com.example.imageloader.model.ObservableView

interface ImageAdapter<T, R> where R: ObservableView<out View> {
    fun getView(data:T, parent: ViewGroup):R
    fun bindView(data:T, view: View, position: Int) {}
}