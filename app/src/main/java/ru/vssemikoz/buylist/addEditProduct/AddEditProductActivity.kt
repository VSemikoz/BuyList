package ru.vssemikoz.buylist.addEditProduct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.vssemikoz.buylist.R
import ru.vssemikoz.buylist.utils.ActivityUtils

class AddEditProductActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addedit_product_act)
        var addEditProductFragment: AddEditProductFragment? =
            supportFragmentManager.findFragmentById(R.id.fl_add_edit_task) as AddEditProductFragment?
        if (addEditProductFragment == null) {
            addEditProductFragment = AddEditProductFragment()
            ActivityUtils.addFragmentToActivity(
                supportFragmentManager, addEditProductFragment, R.id.fl_add_edit_task
            )
        }
    }
}
