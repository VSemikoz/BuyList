package ru.vssemikoz.buylist.utils.navigator

import ru.vssemikoz.buylist.addEditCategory.AddEditCategoryDialogFragment
import ru.vssemikoz.buylist.categoryList.CategoryListFragment
import ru.vssemikoz.buylist.models.Category
import ru.vssemikoz.buylist.models.Product


interface Navigator {

    fun openAddEditProduct(product: Product?)

    fun openCategoryList()

    fun openAddEditCategory(
        category: Category?,
        fragment: CategoryListFragment,
        listener: AddEditCategoryDialogFragment.OnButtonClickedListener
    )
}
