package ru.vssemikoz.buylist.data

import androidx.room.*
import ru.vssemikoz.buylist.models.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    @Query("SELECT * FROM Product WHERE name == :name")
    fun getProductsByName(name: String): List<Product>

    @Query("SELECT * FROM Product")
    fun allProducts(): List<Product>

    @Update
    fun updateProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)

    @Query("DELETE FROM Product")
    fun deleteAll()

    @Query("SELECT * FROM Product WHERE id == :id")
    fun getProductById(id: Int): List<Product>

    @Query("SELECT * FROM Product WHERE is_favorite == 1")
    fun getFavoriteProducts(): List<Product>

    @Query("SELECT * FROM Product WHERE is_add == 1")
    fun getAddedProducts(): List<Product>
}
