package ru.vssemikoz.buylist.productLists

import ru.vssemikoz.buylist.MainApplication
import ru.vssemikoz.buylist.data.AppState
import ru.vssemikoz.buylist.data.LocalProductsStorage
import ru.vssemikoz.buylist.models.Product
import javax.inject.Inject

class ProductListsPresenter @Inject constructor() : ProductListsContract.Presenter {

    private lateinit var view: ProductListsContract.View
    @Inject
    lateinit var productStorage: LocalProductsStorage
    @Inject
    lateinit var mainApplication: MainApplication


    override fun setView(view: ProductListsContract.View) {
        this.view = view
    }

    override fun deleteProduct(product: Product) {
        productStorage.deleteProduct(product)

    }

    override fun updateProduct(product: Product) {
        productStorage.updateProduct(product)

    }

    override fun filterIsAddNews() {
        val listOfProducts = productStorage.getAddedProducts()
        view.changeAppState(AppState.AddList)
        view.showProductList(listOfProducts)
    }

    override fun filterFavoriteNews() {
        val listOfProducts = productStorage.getFavoriteProducts()
        view.changeAppState(AppState.FavoriteList)
        view.showProductList(listOfProducts)
    }

    override fun filterAllProduct() {
        val listOfProducts = productStorage.getAllProducts()
        view.changeAppState(AppState.MainList)
        view.showProductList(listOfProducts)
    }

    override fun subscribe() {
        initStartValues()
        showInitList()
    }


    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initStartValues() {
//      TODO
    }

    private fun showInitList() {
        val listOfProducts = productStorage.getAllProducts()
        view.showProductList(listOfProducts)
    }
}
