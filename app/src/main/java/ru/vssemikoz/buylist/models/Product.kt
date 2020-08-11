package ru.vssemikoz.buylist.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val price: Double,
    val category: String,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean = false,
    @ColumnInfo(name = "is_add")
    val isAdd: Boolean = false
) :Serializable{

    override fun toString(): String {
        return "Product(name='$name', price=$price, category='$category', isFavorite=$isFavorite, isAdd=$isAdd)"
    }

}

