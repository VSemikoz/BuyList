package ru.vssemikoz.buylist.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Product(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String,
    var price: Double,
    var category: String = "default",
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false,
    @ColumnInfo(name = "is_add")
    var isAdd: Boolean = false
) :Serializable{

    override fun toString(): String {
        return "Product(name='$name', price=$price, category='$category', isFavorite=$isFavorite, isAdd=$isAdd)"
    }

}

