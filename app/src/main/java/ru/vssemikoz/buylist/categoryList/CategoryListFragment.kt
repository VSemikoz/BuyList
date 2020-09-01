package ru.vssemikoz.buylist.categoryList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.vssemikoz.buylist.MainApplication
import ru.vssemikoz.buylist.R
import ru.vssemikoz.buylist.adapters.BaseAdapter
import ru.vssemikoz.buylist.adapters.CategoryAdapter
import ru.vssemikoz.buylist.models.Category
import ru.vssemikoz.buylist.utils.navigator.Navigator
import javax.inject.Inject

class CategoryListFragment @Inject constructor() : Fragment(), CategoryListContract.View {
    val TAG = javaClass.name
    @Inject
    lateinit var mPresenter: CategoryListContract.Presenter
    @Inject
    lateinit var adapter: BaseAdapter<Category>
    @Inject
    lateinit var navigator: Navigator
    private lateinit var recyclerView: RecyclerView
    private var addProductFAB: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        MainApplication.getApplicationComponent().fragmentComponent().inject(this)
        mPresenter.setView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.category_list_frag, container, false)
        initViews(root)
        return root
    }

    override fun onResume() {
        super.onResume()
        mPresenter.subscribe()
    }

    private fun initViews(root: View) {
        recyclerView = root.findViewById(R.id.rv_category)
        activity?.apply {
            addProductFAB = findViewById(R.id.fab_category_add)
        }
        addProductFAB?.setOnClickListener { navigator.openAddEditCategory(null) }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val numberOfColumns = 3
        recyclerView.layoutManager = GridLayoutManager(context, numberOfColumns)
        recyclerView.adapter = adapter
        adapter.listener = object : CategoryAdapter.OnCategoryItemClickListener {

            override fun onRecyclerItemClick(position: Int) {
                return
            }

            override fun onDeleteItemClick(position: Int) {
                adapter.items?.get(position)?.also {
                    mPresenter.deleteCategory(it)
                    adapter.notifyItemRemoved(position)
                }
            }

            override fun onChangeItemClick(position: Int) {
                adapter.items?.get(position)?.also {
                    mPresenter.changeCategory(it)
                }
            }
        }

    }

    override fun openAddEditCategory(category: Category) {
        navigator.openAddEditCategory(category.id)
    }

    override fun showCategoryList(categories: List<Category>) {
        adapter.items = categories
        adapter.notifyDataSetChanged()
    }

    override fun setPresenter(presenter: CategoryListContract.Presenter) {
        this.mPresenter = presenter
    }
}
