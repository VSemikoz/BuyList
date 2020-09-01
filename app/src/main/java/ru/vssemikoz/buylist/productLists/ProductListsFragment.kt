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
import ru.vssemikoz.buylist.adapters.ProductAdapter
import ru.vssemikoz.buylist.adapters.TouchHelperAdapter
import ru.vssemikoz.buylist.models.AppState
import ru.vssemikoz.buylist.models.Product
import ru.vssemikoz.buylist.utils.navigator.Navigator
import javax.inject.Inject

class ProductListsFragment @Inject constructor() : Fragment(), ProductListsContract.View {
    val TAG = javaClass.name
    @Inject
    lateinit var mPresenter: ProductListsContract.Presenter
    @Inject
    lateinit var adapter: TouchHelperAdapter<Product>
    @Inject
    lateinit var navigator: Navigator
    var appState: AppState = AppState.MainList

    private lateinit var recyclerView: RecyclerView
    private var addProductFAB: FloatingActionButton? = null
    private var searchIB: ImageButton? = null
    private var sendIB: ImageButton? = null
    private var mainIB: ImageButton? = null
    private var favoriteIB: ImageButton? = null
    private var categoryIB: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
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
            favoriteIB = findViewById(R.id.ib_faworite)
            categoryIB = findViewById(R.id.ib_category)
            addProductFAB = findViewById(R.id.fab_product_add)
        }

        addProductFAB?.setOnClickListener { openAddEditProduct(null) }
        sendIB?.setOnClickListener { mPresenter.filterIsAddNews() }
        favoriteIB?.setOnClickListener { mPresenter.filterFavoriteNews() }
        mainIB?.setOnClickListener { mPresenter.filterAllProduct() }
        categoryIB?.setOnClickListener {
            navigator.openCategoryList()
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        adapter.getTouchHelper().attachToRecyclerView(recyclerView)
        adapter.listener = object : ProductAdapter.OnProductItemClickListener {

            override fun onRecyclerItemClick(position: Int) {
                val product = adapter.items?.get(position)
                openAddEditProduct(product)
            }

            override fun onChangeFavoriteStateClick(position: Int) {
                val product = adapter.items?.get(position)?.apply {
                    isFavorite = !isFavorite
                }
                if (product != null) {
                    mPresenter.updateProduct(product)
                    when (appState) {
                        AppState.FavoriteList -> adapter.deleteItem(position)
                        else -> adapter.notifyItemChanged(position)
                    }
                }
            }

            override fun onChangeIsAddStateClick(position: Int) {
                val product = adapter.items?.get(position)?.apply {
                    isAdd = !isAdd
                }
                if (product != null) {
                    mPresenter.updateProduct(product)
                    when (appState) {
                        AppState.AddList -> adapter.deleteItem(position)
                        else -> adapter.notifyItemChanged(position)
                    }
                }
            }

            override fun onRecyclerItemSwipe(position: Int) {
                adapter.items?.get(position)?.also {
                    mPresenter.deleteProduct(it)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mPresenter.subscribe()
    }

    override fun openAddEditProduct(product: Product?) {
        navigator.openAddEditProduct(product)
    }

    override fun showProductList(products: List<Product>) {
        adapter.items = products
        adapter.notifyDataSetChanged()
    }

    override fun changeAppState(state: AppState) {
        appState = state
    }

    override fun setPresenter(presenter: ProductListsContract.Presenter) {
        this.mPresenter = presenter
    }

}
