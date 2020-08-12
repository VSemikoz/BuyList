package ru.vssemikoz.buylist.utils.navigator

import android.content.Context

interface Navigator {

    fun openAddEditProduct(context: Context, productId: Int?)
}
