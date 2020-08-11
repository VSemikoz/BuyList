package ru.vssemikoz.buylist.addEditProduct

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.vssemikoz.buylist.MainApplication
import ru.vssemikoz.buylist.R
import ru.vssemikoz.buylist.models.Product
import ru.vssemikoz.buylist.utils.navigator.Navigator
import javax.inject.Inject

class AddEditProductFragment : Fragment(), AddEditProductContract.View {
    @Inject
    lateinit var mPresenter: AddEditProductContract.Presenter
    @Inject
    lateinit var navigator: Navigator

    private var productNameTV: TextView? = null
    private var productPriceTV: TextView? = null
    private var productCategorySp: Spinner? = null
    private var addEditFAB: FloatingActionButton? = null

    private var showedProduct: Product? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.getApplicationComponent().fragmentComponent().inject(this)
        mPresenter.setView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.addedit_product_frag, container, false)
        initViews(root)
        return root
    }

    private fun initViews(root: View) {
        productNameTV = root.findViewById(R.id.tv_product_name)
        productPriceTV = root.findViewById(R.id.tv_product_price)
        productCategorySp = root.findViewById(R.id.sp_product_category)
        activity?.apply {
            addEditFAB = findViewById(R.id.fab_edit_task_done)
        }
        addEditFAB?.setOnClickListener {
            if (fieldsIsNotEmpty()) {
                val currProduct = Product(
                    name = productNameTV?.text.toString(),
                    price = productPriceTV?.text.toString().toDouble(),
                    category = productCategorySp?.selectedItem.toString()
                )
                mPresenter.saveProduct(currProduct)
            } else {
//                TODO Accent on empty fields
            }

        }
    }

    fun fieldsIsNotEmpty(): Boolean = productNameTV?.text != "" &&
            productPriceTV?.text != "" &&
            productCategorySp?.selectedItem != null

    override fun showProduct() {
        if (showedProduct != null) {

        } else {
            Log.d("AddEditProductFragment", "showProduct")
        }
    }

    override fun onProductSaved() {
        activity?.finish()
    }

    override fun setPresenter(presenter: AddEditProductContract.Presenter) {
        this.mPresenter = presenter
    }

}
