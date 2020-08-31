package ru.vssemikoz.buylist.utils.navigator

import android.content.Context
import android.content.Intent
import ru.vssemikoz.buylist.addEditProduct.AddEditProductActivity
import ru.vssemikoz.buylist.categoryList.CategoryListActivity
import javax.inject.Inject

class NavigatorImpl @Inject constructor(val context: Context) : Navigator {

    override fun openAddEditProduct(productId: Int?) {
        Intent(context, AddEditProductActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            if (productId != null) {
                putExtra("productId", productId)
            }
            context.startActivity(this)
        }
    }

    override fun openAddEditCategory(categoryId: Int?) {
        TODO()
//        Intent(context, AddEditCategoryActivity::class.java).apply {
//            flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            if (categoryId != null) {
//                putExtra("productId", categoryId)
//            }
//            context.startActivity(this)
//        }
    }

    override fun openCategoryList() {
        Intent(context, CategoryListActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(this)
        }
    }
}
