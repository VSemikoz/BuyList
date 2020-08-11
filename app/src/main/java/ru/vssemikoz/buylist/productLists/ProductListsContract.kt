package ru.vssemikoz.buylist.productLists

import android.content.Context
import ru.vssemikoz.buylist.BasePresenter
import ru.vssemikoz.buylist.BaseView
import ru.vssemikoz.buylist.models.Product

interface ProductListsContract {

    interface View : BaseView<Presenter> {
        fun openNewWindow()

        fun showProductList(products: List<Product>)

        fun setList(products: List<Product>)

    }

    interface Presenter : BasePresenter{
        fun openWindow()

        fun setView(view: ProductListsContract.View)

    }
}
