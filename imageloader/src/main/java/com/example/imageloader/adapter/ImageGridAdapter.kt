package com.example.imageloader.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.imageloader.listener.OnItemClickListener
import com.example.imageloader.model.ResourceData

class ImageGridAdpater(private val resourceAdapter: ImageAdapter<Any, *>, private val onItemClickListener: OnItemClickListener?) : RecyclerView.Adapter<ImageGridAdpater.GridViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(resourceAdapter, resourceAdapter.getView(resourceDataList[0], parent) as View, onItemClickListener)
    }

    private var resourceDataList: ArrayList<ResourceData<Any>> = ArrayList()

    override fun getItemCount(): Int {
        return resourceDataList.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        if (position in 0..1) {

        }
        holder.bindData(resourceDataList[position])
    }

    fun setResourceData(resourceDataList: ArrayList<ResourceData<Any>>) {
        this.resourceDataList = resourceDataList
        notifyDataSetChanged()
    }

    class GridViewHolder(private val resourceDataAdapter: ImageAdapter<Any, *>, view: View, private val onItemClickListener: OnItemClickListener?) : RecyclerView.ViewHolder(view) {

        var resourceData: ResourceData<*>? = null
            private set

        fun bindData(resourceData: ResourceData<*>) {
            itemView.setOnClickListener { clickableVIew->onItemClickListener?.onItemClick(clickableVIew, adapterPosition) }
            resourceDataAdapter.bindView(resourceData, itemView,adapterPosition)
            this.resourceData = resourceData
        }
    }
}