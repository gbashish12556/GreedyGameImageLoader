package com.example.imageloader.component

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.example.imageloader.model.ClickObserverData
import com.example.imageloader.model.ObservableView
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe

class ImageViewItem(context: Context, attrs: AttributeSet? = null) : ImageView(context, attrs),
    ObservableView<ImageViewItem> {
    open override val clickListenerObservable: Observable<ClickObserverData>

    init {
        clickListenerObservable = Observable.create(ObservableOnSubscribe<ClickObserverData> {
                e-> setOnClickListener { view-> e.onNext(ClickObserverData(view))}
        }).share()
    }

}