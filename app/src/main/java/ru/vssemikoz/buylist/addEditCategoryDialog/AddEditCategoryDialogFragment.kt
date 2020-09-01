package ru.vssemikoz.buylist.addEditCategoryDialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import ru.vssemikoz.buylist.MainApplication
import ru.vssemikoz.buylist.R
import ru.vssemikoz.buylist.models.Category
import javax.inject.Inject


class AddEditCategoryDialogFragment(private val listener: OnButtonClickedListener) : DialogFragment(),
    AddEditCategoryContract.View {

    interface OnButtonClickedListener {
        fun onAddClicked(category: Category)
    }

    @Inject
    lateinit var presenter: AddEditCategoryContract.Presenter
    var sendCategory: Category? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.DialogStyle)
        sendCategory = arguments?.getSerializable("Category") as Category?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        MainApplication.getApplicationComponent().fragmentComponent().inject(this)
        presenter.setView(this)

        val v: View = inflater.inflate(R.layout.add_edit_category, null)
        val categoryNameTV = v.findViewById<EditText>(R.id.et_add_edit_category_name)
        val addButton = v.findViewById<Button>(R.id.b_add_edit_category)
        val cancelButton = v.findViewById<Button>(R.id.b_cancel_add_edit_category)

        if (sendCategory != null) categoryNameTV.setText(sendCategory!!.name)

        addButton.setOnClickListener {
            if (validInput(categoryNameTV.text)) {
                val category = Category(name = categoryNameTV.text.toString())
                presenter.addCategory(category)
                listener.onAddClicked(category)
                dismiss()
            }
        }

        cancelButton.setOnClickListener {
            dismiss()
        }
        return v
    }

    private fun validInput(text: CharSequence?): Boolean = text !in listOf(null, "")
}
