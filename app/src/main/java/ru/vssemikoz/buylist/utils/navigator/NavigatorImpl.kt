package ru.vssemikoz.buylist.utils.navigator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import ru.vssemikoz.buylist.addEditProduct.AddEditProductActivity
import javax.inject.Inject

class NavigatorImpl @Inject constructor() : Navigator {

    override fun openAddEditProduct(context: Context, bundle: Bundle?) {
        val intent = Intent(context, AddEditProductActivity::class.java)
        ContextCompat.startActivity(context, intent, bundle)
    }
}
