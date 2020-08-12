package ru.vssemikoz.buylist.productLists

import ru.vssemikoz.buylist.BasePresenter
import ru.vssemikoz.buylist.BaseView
import ru.vssemikoz.buylist.models.Product

interface ProductListsContract {

    interface View : BaseView<Presenter> {

        fun openAddEditProduct(productId: Int?)

        fun showProductList(products: List<Product>)

    }

    interface Presenter : BasePresenter{

        fun setView(view: ProductListsContract.View)

        fun deleteProduct(product: Product)

        fun updateProduct(product: Product)

        fun filterIsAddNews()

        fun filterFavoriteNews()

        fun filterAllProduct()

    }
}
