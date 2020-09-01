package ru.vssemikoz.buylist.utils.navigator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import ru.vssemikoz.buylist.addEditCategoryDialog.AddEditCategoryDialogFragment
import ru.vssemikoz.buylist.addEditProduct.AddEditProductActivity
import ru.vssemikoz.buylist.categoryList.CategoryListActivity
import ru.vssemikoz.buylist.categoryList.CategoryListFragment
import ru.vssemikoz.buylist.models.Category
import ru.vssemikoz.buylist.models.Product
import javax.inject.Inject

class NavigatorImpl @Inject constructor(val context: Context) : Navigator {
    override fun openAddEditProduct(product: Product?) {
        Intent(context, AddEditProductActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            if (product != null) {
                val bundle = Bundle()
                bundle.putSerializable("Product", product)
                putExtras(bundle)
            }
            context.startActivity(this)
        }
    }

    override fun openAddEditCategory(
        category: Category?,
        fragment: CategoryListFragment,
        listener: AddEditCategoryDialogFragment.OnButtonClickedListener
    ) {
        AddEditCategoryDialogFragment(listener).apply {
            if (category != null){
                val bundle = Bundle()
                bundle.putSerializable("Category", category)
                arguments = bundle
            }
            show(fragment.fragmentManager, "addEditCategoryDialog")
        }
    }

    override fun openCategoryList() {
        Intent(context, CategoryListActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(this)
        }
    }
}
