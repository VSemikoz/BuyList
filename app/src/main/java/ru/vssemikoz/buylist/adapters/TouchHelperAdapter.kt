package ru.vssemikoz.buylist.adapters

import android.content.Context
import androidx.recyclerview.widget.ItemTouchHelper

abstract class TouchHelperAdapter<T>(context: Context) : BaseAdapter<T>(context) {

    interface OnTHRecyclerItemClickListener : BaseAdapter.OnRecyclerItemClickListener {
        fun onRecyclerItemSwipe(position: Int)
    }

    abstract fun getTouchHelper(): ItemTouchHelper
}
