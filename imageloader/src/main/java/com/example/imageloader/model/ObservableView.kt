package com.example.imageloader.model

import io.reactivex.Observable

interface ObservableView<out View> {
    val clickListenerObservable: Observable<ClickObserverData>
}
