package ru.vssemikoz.buylist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import ru.vssemikoz.buylist.R
import ru.vssemikoz.buylist.data.IconicStorage
import ru.vssemikoz.buylist.data.LocalIconicStorage
import ru.vssemikoz.buylist.models.Product
import javax.inject.Inject

class ProductAdapter @Inject constructor(context: Context) : BaseAdapter<Product>(context) {

    var iconicStorage: IconicStorage = LocalIconicStorage()

    public interface OnProductItemClickListener : OnRecyclerItemClickListener {

        override fun onRecyclerItemClick(position: Int)

        fun onChangeFavoriteStateClick(position: Int)

        fun onChangeIsAddStateClick(position: Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Product> {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view, listener)

    }

    inner class ProductViewHolder(view: View, listener: OnRecyclerItemClickListener?) :
        BaseViewHolder<Product>(view) {
        var favoriteState: Boolean = false
        var isAddState: Boolean = false
        val cardView: CardView = view.findViewById(R.id.cv_item)
        val productName: TextView = view.findViewById(R.id.tv_product_name)
        val productPrice: TextView = view.findViewById(R.id.tv_product_price)
        var favoriteStateIB: ImageView = view.findViewById(R.id.ib_favorite)
        val isAddStateIB: ImageView = view.findViewById(R.id.ib_isAdd)

        init {
            favoriteStateIB.setOnClickListener {
                listener as OnProductItemClickListener
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    listener.onChangeFavoriteStateClick(adapterPosition)
                    favoriteState = !favoriteState
                }
            }

            isAddStateIB.setOnClickListener {
                listener as OnProductItemClickListener
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    listener.onChangeIsAddStateClick(adapterPosition)
                    isAddState = !isAddState
                }
            }

            cardView.setOnClickListener {
                listener as OnProductItemClickListener
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    listener.onRecyclerItemClick(adapterPosition)
                }
            }
        }

        override fun onBind(item: Product, listener: OnRecyclerItemClickListener?) {
            productName.text = item.name
            productPrice.text = item.price.toString()
            favoriteState = item.isFavorite
            isAddState = item.isAdd

            when (item.isFavorite) {
                true -> favoriteStateIB.setImageDrawable(
                    iconicStorage.getIsFollowedDrawable(
                        context
                    )
                )
                false -> favoriteStateIB.setImageDrawable(
                    iconicStorage.getIsUnfollowedDrawable(
                        context
                    )
                )
            }

            when (item.isAdd) {
                true -> isAddStateIB.setImageDrawable(iconicStorage.getIsAddDrawwble(context))
                false -> isAddStateIB.setImageDrawable(iconicStorage.getIsNotAddDrawwble(context))
            }

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
                val position = viewHolder.adapterPosition
                listener?.onRecyclerItemSwipe(position)
            }
        })
    }
}
