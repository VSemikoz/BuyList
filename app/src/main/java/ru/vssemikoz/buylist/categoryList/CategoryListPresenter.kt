package ru.vssemikoz.buylist.categoryList

import android.util.Log
import ru.vssemikoz.buylist.MainApplication
import ru.vssemikoz.buylist.data.CategoryStorage
import ru.vssemikoz.buylist.models.Category
import javax.inject.Inject

class CategoryListPresenter @Inject constructor() : CategoryListContract.Presenter {
    val TAG = javaClass.name
    private lateinit var view: CategoryListContract.View
    @Inject
    lateinit var categoryStorage: CategoryStorage
    @Inject
    lateinit var mainApplication: MainApplication

    override fun setView(view: CategoryListContract.View) {
        this.view = view
    }

    override fun deleteCategory(category: Category) {
        categoryStorage.deleteCategory(category)
    }

    override fun changeCategory(category: Category) {
        view.openAddEditCategory(category)
    }

    override fun subscribe() {
        showInitList()
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun showInitList() {
        val categories = categoryStorage.getAllCategory()
        Log.d(TAG, categories.toString())
        view.showCategoryList(categories)
    }
}

