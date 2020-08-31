package ru.vssemikoz.buylist.productLists

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.vssemikoz.buylist.R
import ru.vssemikoz.buylist.utils.ActivityUtils

class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_list_act)
        var productListFragment: ProductListsFragment? =
            supportFragmentManager.findFragmentById(R.id.fl_main_product_list) as ProductListsFragment?
        if (productListFragment == null) {
            productListFragment = ProductListsFragment()
            ActivityUtils.addFragmentToActivity(
                supportFragmentManager, productListFragment, R.id.fl_main_product_list
            )
        }
    }
}
