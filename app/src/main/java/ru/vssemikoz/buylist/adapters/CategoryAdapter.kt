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
import ru.vssemikoz.buylist.data.LocalIconicStorage
import ru.vssemikoz.buylist.models.Category
import javax.inject.Inject

class CategoryAdapter @Inject constructor(context: Context) : BaseAdapter<Category>(context) {
    var iconicStorage: IconicStorage = LocalIconicStorage()

    public interface OnCategoryItemClickListener : OnRecyclerItemClickListener {

        override fun onRecyclerItemClick(position: Int)

        fun onDeleteItemClick(position: Int)

        fun onChangeItemClick(position: Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Category> {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return CategoryViewHolder(view, listener)
    }

    inner class CategoryViewHolder(view: View, listener: OnRecyclerItemClickListener?) :
        BaseViewHolder<Category>(view) {
        val cardView: CardView = view.findViewById(R.id.cv_item)
        val categoryName: TextView = view.findViewById(R.id.tv_category_name)
        val deleteIB: ImageButton = view.findViewById(R.id.iv_delete_category)
        val changeIB: ImageButton = view.findViewById(R.id.iv_change_category)

        init {
            cardView.setOnClickListener {
                showButtons()
            }

            deleteIB.setOnClickListener {
                listener as OnCategoryItemClickListener
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    listener.onDeleteItemClick(adapterPosition)
                }
            }

            deleteIB.setOnClickListener {
                listener as OnCategoryItemClickListener
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    listener.onChangeItemClick(adapterPosition)
                }
            }
        }

        override fun onBind(item: Category, listener: OnRecyclerItemClickListener?) {
            categoryName.text = item.name

        }

        fun hideButtons() {
            deleteIB.visibility = View.GONE
            changeIB.visibility = View.GONE
        }

        fun showButtons() {
            deleteIB.visibility = View.VISIBLE
            changeIB.visibility = View.VISIBLE
        }

    }

    override fun getTouchHelper(): ItemTouchHelper {
        return ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                return
            }

        })
    }
}
