package com.example.imageloader.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imageloader.adapter.ImageAdapter
import com.example.imageloader.adapter.ImageGridAdpater
import com.example.imageloader.adapter.RecyclerImageAdapter
import com.example.imageloader.listener.OnItemClickListener
import com.example.imageloader.model.ResourceData
import io.reactivex.Observable
import kotlin.properties.Delegates

open class ImageGridView : RecyclerView, OnItemClickListener {

    override fun onItemClick(view: View, position: Int) {
        itemClickListener.invoke(view, position)
    }

    private var itemClickListener: (View: View, position: Int) -> Unit = { view: View, i: Int -> }

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet? = null) : super(context, attributeSet)

    private lateinit var contentChildAdapter: ImageGridAdpater
    private var itemWidth: Int = 0

    var gridData: List<ResourceData<Any>> by Delegates.observable(listOf()) { property, oldValue, newValue ->
        contentChildAdapter.setResourceData(
            ArrayList(newValue)
        )
    }
    var gridResourceDataAdapter: ImageAdapter<Any, *> by Delegates.observable(RecyclerImageAdapter() as ImageAdapter<Any, *>) { property, oldValue, newValue ->
        swapAdapter(
            newValue
        )
    }

    var onSelectObservable: Observable<ResourceData<Any>>
        private set

    private val numberOfColumn: Int = 3

    init {
        layoutManager = GridLayoutManager(context, 1)
        itemAnimator = DefaultItemAnimator()
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, dpToPixel(200,context))
        contentChildAdapter = ImageGridAdpater(gridResourceDataAdapter, this)
        adapter = contentChildAdapter
        setHasFixedSize(true)
        clipToPadding = false

        onSelectObservable = Observable.create<ResourceData<Any>> { emitter ->
            itemClickListener = { view: View, position: Int ->
                val viewHolder = findContainingViewHolder(view) as ImageGridAdpater.GridViewHolder
                emitter.onNext(viewHolder.resourceData as ResourceData<Any>)
            }
        }
    }

    fun dpToPixel(dp: Int, context: Context): Int {
        val r = context.getResources()
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            r.getDisplayMetrics()
        ).toInt()

        return px

    }

    private fun swapAdapter(resourceDataAdapter: ImageAdapter<Any, *>) {
        contentChildAdapter = ImageGridAdpater(resourceDataAdapter, this)
        adapter = contentChildAdapter
    }
}