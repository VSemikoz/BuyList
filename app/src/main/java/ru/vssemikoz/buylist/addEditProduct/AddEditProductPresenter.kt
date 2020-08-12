package ru.vssemikoz.buylist.addEditProduct

import ru.vssemikoz.buylist.MainApplication
import ru.vssemikoz.buylist.data.LocalProductsStorage
import ru.vssemikoz.buylist.models.Product
import javax.inject.Inject

class AddEditProductPresenter @Inject constructor() : AddEditProductContract.Presenter {

    @Inject
    lateinit var mainApplication: MainApplication
    @Inject
    lateinit var productStorage: LocalProductsStorage

    private lateinit var view: AddEditProductContract.View


    override fun setView(view: AddEditProductContract.View) {
        this.view = view
    }

    override fun saveProduct(product: Product) {
        productStorage.insertProduct(product)
        view.onProductSaved()
    }

    override fun setProductToSetById(id: Int) {
        val product = productStorage.getProductById(id)
        view.showProduct(product)
    }

    override fun subscribe() {
        initStartValues()
    }

    private fun initStartValues() {

    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
