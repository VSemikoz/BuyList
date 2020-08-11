package ru.vssemikoz.buylist.productLists

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.vssemikoz.buylist.R
import ru.vssemikoz.buylist.utils.ActivityUtils

class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)
        var productListFragment: ProductListsFragment? =
            supportFragmentManager.findFragmentById(R.id.main_list_frame) as ProductListsFragment?
        if (productListFragment == null) {
            productListFragment = ProductListsFragment()
            ActivityUtils.addFragmentToActivity(
                supportFragmentManager, productListFragment, R.id.main_list_frame
            )
        }
    }
}
