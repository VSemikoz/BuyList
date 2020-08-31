package ru.vssemikoz.buylist.utils.navigator


interface Navigator {

    fun openAddEditProduct(productId: Int?)

    fun openAddEditCategory(categoryId: Int?)

    fun openCategoryList()
}
