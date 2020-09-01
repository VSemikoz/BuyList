package ru.vssemikoz.buylist.addEditProduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.vssemikoz.buylist.MainApplication
import ru.vssemikoz.buylist.R
import ru.vssemikoz.buylist.models.Category
import ru.vssemikoz.buylist.models.Product
import ru.vssemikoz.buylist.utils.navigator.Navigator
import ru.vssemikoz.buylist.utils.navigator.typeConverter.CategoryConverter
import javax.inject.Inject


class AddEditProductFragment : Fragment(), AddEditProductContract.View {
    @Inject
    lateinit var mPresenter: AddEditProductContract.Presenter
    @Inject
    lateinit var navigator: Navigator

    private lateinit var availableCategories: List<Category>
    private var sendProduct: Product? = null
    private var productNameTV: TextView? = null
    private var productPriceTV: TextView? = null
    private var productCategorySp: Spinner? = null
    private var addEditFAB: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.getApplicationComponent().fragmentComponent().inject(this)
        mPresenter.setView(this)
        activity?.intent?.extras.let {
            if (it != null) {
                sendProduct = it.getSerializable("Product") as Product
            }
        }
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
        setupSpinner()
        addEditFAB = activity?.findViewById(R.id.fab_category_add)

        addEditFAB?.setOnClickListener {
            if (fieldsIsNotEmpty()) {
                if (sendProduct == null) mPresenter.saveProduct(Product(
                    name = productNameTV?.text.toString(),
                    price = productPriceTV?.text.toString().toDouble(),
                    category = CategoryConverter.fromCategoryName(productCategorySp?.selectedItem.toString())
                ))
                else mPresenter.updateProduct(sendProduct!!.apply {
                    name = productNameTV?.text.toString()
                    price = productPriceTV?.text.toString().toDouble()
                    category = CategoryConverter.fromCategoryName(productCategorySp?.selectedItem.toString())
                })
            } else {
//                TODO Accent on empty fields
            }
        }

        if (sendProduct != null) showProduct(sendProduct!!)
    }

    private fun setupSpinner() {
        availableCategories = mPresenter.getCategories()
        val categoriesNames = availableCategories.map { it.name }
        ArrayAdapter(
            context!!, android.R.layout.simple_spinner_item, categoriesNames
        ).let {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            productCategorySp!!.adapter = it
        }
    }

    private fun fieldsIsNotEmpty(): Boolean = productNameTV?.text!!.isNotEmpty() &&
            productPriceTV?.text!!.isNotEmpty()

    override fun showProduct(product: Product) {
        productNameTV!!.text = product.name
        productPriceTV!!.text = product.price.toString()
        val category = Category(name = CategoryConverter.fromCategory(product.category))
        val indexOfCategory = availableCategories.indexOf(category)
        productCategorySp?.setSelection(indexOfCategory)
    }

    override fun onProductSaved() {
        activity?.finish()
    }

    override fun setPresenter(presenter: AddEditProductContract.Presenter) {
        this.mPresenter = presenter
    }

}
