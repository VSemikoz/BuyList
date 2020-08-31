package ru.vssemikoz.buylist.data.localStorage

import ru.vssemikoz.buylist.data.CategoryDao
import ru.vssemikoz.buylist.data.CategoryStorage
import ru.vssemikoz.buylist.models.Category
import javax.inject.Inject

class LocalCategoryStorage @Inject constructor(appDB: LocalAppDB) : CategoryStorage {

    private val categoryDao: CategoryDao = appDB.categoryDao()

    override fun insertCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    override fun getCategoryByName(name: String): List<Category> {
        return categoryDao.getCategoryByName(name)
    }

    override fun getAllCategory(): List<Category> {
        return categoryDao.getAllCategory()
    }

    override fun updateCategory(category: Category) {
        categoryDao.updateCategory(category)
    }

    override fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }

    override fun deleteAll() {
        categoryDao.deleteAll()
    }

    override fun getCategoryById(id: Int): List<Category> {
        return categoryDao.getCategoryById(id)
    }
}
