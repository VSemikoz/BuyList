package ru.vssemikoz.buylist.data

import android.util.Log
import ru.vssemikoz.buylist.models.Product
import javax.inject.Inject

class LocalProductsStorage @Inject constructor(appDB: AppDB) : ProductStorage {
    private val productDao: ProductDao = appDB.productDao()

    override fun getAllProducts(): List<Product> {
        Log.d("LocalProductsStorage", "${productDao.allProducts()}")
        return productDao.allProducts()
    }

    override fun deleteAllProducts() {
        productDao.deleteAll()
    }

    override fun deleteProduct(product: Product) {
        productDao.deleteProduct(product)
    }

    override fun insertProduct(product: Product) {
        productDao.insertProduct(product)
    }

    override fun updateProduct(product: Product) {
        productDao.updateProduct(product)
    }

    override fun getProductById(id: Int): Product {
        return productDao.getProductById(id)[0]
    }

    override fun getFavoriteProducts(): List<Product> {
        return productDao.getFavoriteProducts()
    }

    override fun getAddedProducts(): List<Product> {
        return productDao.getAddedProducts()
    }
}
