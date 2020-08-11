package ru.vssemikoz.buylist.productLists

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.vssemikoz.buylist.MainApplication
import ru.vssemikoz.buylist.R
import ru.vssemikoz.buylist.adapters.BaseAdapter
import ru.vssemikoz.buylist.adapters.ProductAdapter
import ru.vssemikoz.buylist.models.Product
import ru.vssemikoz.buylist.utils.navigator.Navigator
import javax.inject.Inject

class ProductListsFragment @Inject constructor() : Fragment(), ProductListsContract.View {
    @Inject
    lateinit var mPresenter: ProductListsContract.Presenter
    @Inject
    lateinit var adapter: BaseAdapter<Product>
    @Inject
    lateinit var navigator: Navigator

    private lateinit var recyclerView: RecyclerView
    private var addProductFAB: FloatingActionButton? = null
    private var searchIB: ImageButton? = null
    private var sendIB: ImageButton? = null
    private var mainIB: ImageButton? = null
    private var favoriteIB: ImageButton? = null
    private var categoryIB: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("ProductListsFragment", "onCreate")
        super.onCreate(savedInstanceState)
        MainApplication.getApplicationComponent().fragmentComponent().inject(this)
        mPresenter.setView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.product_list_frag, container, false)
        initViews(root)

        return root
    }

    private fun initViews(root: View) {
        recyclerView = root.findViewById(R.id.rv_product)
        activity?.apply {
            searchIB = findViewById(R.id.ib_search)
            sendIB = findViewById(R.id.ib_send)
            mainIB = findViewById(R.id.ib_main)
            favoriteIB = findViewById(R.id.ib_favorite)
            categoryIB = findViewById(R.id.ib_category)
            addProductFAB = findViewById(R.id.fab_edit_task_add)
        }

        addProductFAB?.setOnClickListener { addEditProduct(null) }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        adapter.listener = object : ProductAdapter.OnProductItemClickListener {
            override fun onRecyclerItemClick(position: Int) {
                Log.d("ProductListsFragment", "onRecyclerItemClick")
            }

            override fun onChangeFavoriteStateClick(position: Int) {
                Log.d("ProductListsFragment", "onChangeFavoriteStateClick")
            }

            override fun onChangeIsAddStateClick(position: Int) {
                Log.d("ProductListsFragment", "onChangeIsAddStateClick")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mPresenter.subscribe()
    }


    override fun addEditProduct(bundle: Bundle?) {
        Log.d("ProductListsFragment", "openNewWindow")
        navigator.openAddEditProduct(context!!, bundle)
    }

    override fun showProductList(products: List<Product>) {
        adapter.items = products
    }

    override fun setList(products: List<Product>) {
        Log.d("setList", "$products")

        adapter.items = products
        adapter.notifyDataSetChanged()
    }

    override fun setPresenter(presenter: ProductListsContract.Presenter) {
        this.mPresenter = presenter
    }
}
