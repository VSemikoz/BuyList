package ru.vssemikoz.buylist.utils.navigator.typeConverter

import androidx.room.TypeConverter
import ru.vssemikoz.buylist.models.Category
import kotlin.jvm.internal.Intrinsics


object CategoryConverter {

    @TypeConverter
    @JvmStatic
    fun fromCategoryName(categoryName: String): Category {
        return Category(name = categoryName)
    }

    @TypeConverter
    @JvmStatic
    fun fromCategory(category: Category): String = category.name

}
