package ru.vssemikoz.buylist.data

import androidx.room.*
import ru.vssemikoz.buylist.models.Category

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

    @Query("SELECT * FROM Category WHERE name == :name")
    fun getCategoryByName(name: String): List<Category>

    @Query("SELECT * FROM Category")
    fun getAllCategory(): List<Category>

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)

    @Query("DELETE FROM Category")
    fun deleteAll()

    @Query("SELECT * FROM Category WHERE id == :id")
    fun getCategoryById(id: Int): List<Category>

}
