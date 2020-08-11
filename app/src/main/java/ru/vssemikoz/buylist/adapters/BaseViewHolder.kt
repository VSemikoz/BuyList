package ru.vssemikoz.buylist.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseViewHolder<T>(itemView: View?) : ViewHolder(itemView!!) {
     abstract fun onBind(item: T, listener: BaseAdapter.OnRecyclerItemClickListener?)
}
