package ru.vssemikoz.buylist.addEditCategoryDialog

import ru.vssemikoz.buylist.models.Category

interface AddEditCategoryContract {

    interface Presenter {
        fun setView(view: AddEditCategoryDialogFragment)

        fun addCategory(category: Category)

    }

    interface View
}
