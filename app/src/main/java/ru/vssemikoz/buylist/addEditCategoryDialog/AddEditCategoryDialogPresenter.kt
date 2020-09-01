package ru.vssemikoz.buylist.addEditCategoryDialog

import ru.vssemikoz.buylist.data.CategoryStorage
import ru.vssemikoz.buylist.models.Category
import javax.inject.Inject

class AddEditCategoryDialogPresenter @Inject constructor() : AddEditCategoryContract.Presenter {
    lateinit var view: AddEditCategoryContract.View
    @Inject
    lateinit var categoryStorage: CategoryStorage

    override fun setView(view: AddEditCategoryDialogFragment) {
        this.view = view
    }

    override fun addCategory(category: Category) {
        categoryStorage.insertCategory(category)
    }

}
