package ru.vssemikoz.buylist.categoryList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.vssemikoz.buylist.R
import ru.vssemikoz.buylist.utils.ActivityUtils

class CategoryListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_list_act)
        var categoryListFragment: CategoryListFragment? =
            supportFragmentManager.findFragmentById(R.id.fl_main_category_list) as CategoryListFragment?
        if (categoryListFragment == null) {
            categoryListFragment = CategoryListFragment()
            ActivityUtils.addFragmentToActivity(
                supportFragmentManager, categoryListFragment, R.id.fl_main_category_list
            )
        }
    }
}
