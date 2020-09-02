package ru.vssemikoz.buylist.addEditProduct

import ru.vssemikoz.buylist.MainApplication
import ru.vssemikoz.buylist.data.localStorage.LocalCategoryStorage
import ru.vssemikoz.buylist.data.localStorage.LocalProductsStorage
import ru.vssemikoz.buylist.models.Category
import ru.vssemikoz.buylist.models.Product
import javax.inject.Inject

class AddEditProductPresenter @Inject constructor() : AddEditProductContract.Presenter {

    @Inject
    lateinit var mainApplication: MainApplication
    @Inject
    lateinit var productStorage: LocalProductsStorage
    @Inject
    lateinit var categoryStorage: LocalCategoryStorage

    private lateinit var view: AddEditProductContract.View


    override fun setView(view: AddEditProductContract.View) {
        this.view = view
    }

    override fun saveProduct(product: Product) {
        productStorage.insertProduct(product)
        view.onProductSaved()
    }

    override fun getCategories(): List<Category> {
        return categoryStorage.getAllCategory()
    }

    override fun updateProduct(product: Product) {
        productStorage.updateProduct(product)
        view.onProductSaved()
    }

    override fun subscribe() {
        initStartValues()
    }

    private fun initStartValues() {

    }

    override fun unsubscribe() {
        return
    }
}
