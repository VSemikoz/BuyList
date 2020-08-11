package ru.vssemikoz.buylist.addEditProduct

import ru.vssemikoz.buylist.BasePresenter
import ru.vssemikoz.buylist.BaseView
import ru.vssemikoz.buylist.models.Product

interface AddEditProductContract {

    interface View : BaseView<Presenter> {
        fun showProduct()

        fun onProductSaved()

    }

    interface Presenter : BasePresenter {

        fun setView(view: View)

        fun saveProduct(product: Product)

    }
}
