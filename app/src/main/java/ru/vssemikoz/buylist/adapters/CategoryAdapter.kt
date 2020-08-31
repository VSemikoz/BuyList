package ru.vssemikoz.buylist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import ru.vssemikoz.buylist.R
import ru.vssemikoz.buylist.data.IconicStorage
import ru.vssemikoz.buylist.data.localStorage.LocalIconicStorage
import ru.vssemikoz.buylist.models.Category
import javax.inject.Inject

class CategoryAdapter @Inject constructor(context: Context) : BaseAdapter<Category>(context) {
    var iconicStorage: IconicStorage =
        LocalIconicStorage()

    public interface OnCategoryItemClickListener : OnRecyclerItemClickListener {

        override fun onRecyclerItemClick(position: Int)

        fun onDeleteItemClick(position: Int)

        fun onChangeItemClick(position: Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Category> {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view, listener)
    }

    inner class CategoryViewHolder(view: View, listener: OnRecyclerItemClickListener?) :
        BaseViewHolder<Category>(view) {
        var visibility = false
        val cardView: CardView = view.findViewById(R.id.cv_item)
        val categoryName: TextView = view.findViewById(R.id.tv_category_name)
        val deleteIB: ImageButton = view.findViewById(R.id.iv_delete_category)
        val changeIB: ImageButton = view.findViewById(R.id.iv_change_category)

        init {
            cardView.setOnClickListener {
                when(visibility){
                    true -> hideButtons()
                    false -> showButtons()
                }
                visibility != visibility
            }

            deleteIB.setOnClickListener {
                listener as OnCategoryItemClickListener
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    listener.onDeleteItemClick(adapterPosition)
                }
            }

            changeIB.setOnClickListener {
                listener as OnCategoryItemClickListener
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    listener.onChangeItemClick(adapterPosition)
                }
            }
        }

        override fun onBind(item: Category, listener: OnRecyclerItemClickListener?) {
            categoryName.text = item.name
        }

        public fun hideButtons() {
            deleteIB.visibility = View.GONE
            changeIB.visibility = View.GONE
        }

        public fun showButtons() {
            deleteIB.visibility = View.VISIBLE
            changeIB.visibility = View.VISIBLE
        }

    }
}
