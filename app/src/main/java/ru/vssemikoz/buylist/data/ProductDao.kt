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

}
