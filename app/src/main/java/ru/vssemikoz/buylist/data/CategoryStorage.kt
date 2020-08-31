package ru.vssemikoz.buylist.data

import ru.vssemikoz.buylist.models.Category

interface CategoryStorage {
    fun insertCategory(category: Category)

    fun getCategoryByName(name: String): List<Category>

    fun getAllCategory(): List<Category>

    fun updateCategory(category: Category)

    fun deleteCategory(category: Category)

    fun deleteAll()

    fun getCategoryById(id: Int): List<Category>

}
