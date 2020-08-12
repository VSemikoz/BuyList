package ru.vssemikoz.buylist.adapters

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(val context: Context) : RecyclerView.Adapter<BaseViewHolder<T>>() {
    var items: List<T>? = null
    var listener: OnRecyclerItemClickListener? = null


    open fun setOnItemClickListener(listener: OnRecyclerItemClickListener?) {
        this.listener = listener
    }

    interface OnRecyclerItemClickListener {
        fun onRecyclerItemClick(position: Int)

        fun onRecyclerItemSwipe(position: Int)
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T>

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val item = items?.get(position)
        if (item != null) holder.onBind(item, listener)
    }

    override fun getItemCount(): Int = items?.size ?: 0

    abstract fun getTouchHelper(): ItemTouchHelper
}

