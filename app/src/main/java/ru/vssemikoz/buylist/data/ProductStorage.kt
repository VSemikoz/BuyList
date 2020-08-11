package ru.vssemikoz.buylist.data

import ru.vssemikoz.buylist.models.Product

interface ProductStorage {

    fun getAllProducts():List<Product>

    fun deleteAllProducts()

    fun deleteProduct(product: Product)

    fun insertProduct(product: Product)

    fun updateProduct(product: Product)

}
