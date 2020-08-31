package ru.vssemikoz.buylist.addEditProduct

import android.os.Bundle
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
        productNameTV = root.findViewById(R.id.et_product_name)
        productPriceTV = root.findViewById(R.id.et_product_price)
        productCategorySp = root.findViewById(R.id.sp_product_category)
        activity?.apply {
            addEditFAB = findViewById(R.id.fab_category_add)
        }
        addEditFAB?.setOnClickListener {
            if (fieldsIsNotEmpty()) {
                val currProduct = Product(
                    name = productNameTV?.text.toString(),
                    price = productPriceTV?.text.toString().toDouble()
//                   TODO category = productCategorySp?.selectedItem.toString()
                )
                mPresenter.saveProduct(currProduct)
            } else {
//                TODO Accent on empty fields
            }

        }

        val extras = activity?.intent?.extras
        if (extras != null) {
            val id = extras.getInt("productId")
            mPresenter.setProductToSetById(id)
        }

    }

    private fun fieldsIsNotEmpty(): Boolean = productNameTV?.text != "" &&
            productPriceTV?.text != ""
//      TODO      productCategorySp?.selectedItem != null

    override fun showProduct(product: Product) {
        productNameTV?.text = product.name
        productPriceTV?.text = product.price.toString()
    }

    override fun onProductSaved() {
        activity?.finish()
    }

    override fun setPresenter(presenter: AddEditProductContract.Presenter) {
        this.mPresenter = presenter
    }

}
