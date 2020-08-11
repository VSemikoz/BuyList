package ru.vssemikoz.buylist.productLists

import ru.vssemikoz.buylist.MainApplication
import ru.vssemikoz.buylist.data.LocalProductsStorage
import javax.inject.Inject

class ProductListsPresenter @Inject constructor() : ProductListsContract.Presenter {

    private lateinit var view: ProductListsContract.View
    @Inject lateinit var productStorage: LocalProductsStorage
    @Inject lateinit var mainApplication: MainApplication


    override fun openWindow() {
        view.openNewWindow()
    }

    override fun setView(view: ProductListsContract.View) {
        this.view = view
    }

    override fun subscribe() {
        initStartValues()
        showInitList()
    }


    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initStartValues() {

    }

    private fun showInitList() {
        val listOfProducts = productStorage.getAllProducts()
        view.setList(listOfProducts)
    }
}
