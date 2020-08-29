package com.example.imageloader.component

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import com.example.imageloader.R
import com.example.imageloader.model.ClickObserverData
import com.example.imageloader.model.ObservableView
import io.reactivex.Observable
import kotterknife.bindView

class ImageItemView(context: Context, attributeSet: AttributeSet? = null):
    RelativeLayout(context, attributeSet), ObservableView<ImageItemView> {
    private val gridImageView: ImageView by bindView(R.id.imageView)

    override val clickListenerObservable: Observable<ClickObserverData> = Observable.create{}
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_image_view, this, false)
        addView(view)
        isClickable = true
    }

    fun getImageView():ImageView{
        return gridImageView
    }

}