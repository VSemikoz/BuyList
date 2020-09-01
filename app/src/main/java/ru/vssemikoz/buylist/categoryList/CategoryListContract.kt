package ru.vssemikoz.buylist.categoryList

import ru.vssemikoz.buylist.BasePresenter
import ru.vssemikoz.buylist.BaseView
import ru.vssemikoz.buylist.models.Category

interface CategoryListContract {
    interface View : BaseView<Presenter> {
        fun openAddEditCategory(category: Category?)

        fun showCategoryList(categories: List<Category>)

    }

    interface Presenter : BasePresenter {
        fun setView(view: CategoryListContract.View)

        fun deleteCategory(category: Category)

        fun changeCategory(category: Category)
    }
}
