package ru.vssemikoz.buylist.utils.navigator

import android.content.Context
import android.content.Intent
import ru.vssemikoz.buylist.addEditProduct.AddEditProductActivity
import javax.inject.Inject

class NavigatorImpl @Inject constructor() : Navigator {

    override fun openAddEditProduct(context: Context, productId: Int?) {
        val intent = Intent(context, AddEditProductActivity::class.java)
        if (productId != null){
            intent.putExtra("productId", productId)
        }
        context.startActivity(intent)
    }
}
