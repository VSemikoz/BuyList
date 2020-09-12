package ru.vssemikoz.buylist.data.localStorage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.vssemikoz.buylist.data.dao.CategoryDao
import ru.vssemikoz.buylist.data.dao.ProductDao
import ru.vssemikoz.buylist.models.Category
import ru.vssemikoz.buylist.models.Product
import ru.vssemikoz.buylist.utils.navigator.typeConverter.CategoryConverter

@Database(entities = [Product::class, Category::class], version = 3, exportSchema = false)
@TypeConverters(CategoryConverter::class)
abstract class LocalAppDB : RoomDatabase() {
    abstract fun productDao(): ProductDao

    abstract fun categoryDao(): CategoryDao

    companion object {

        private var INSTANCE: LocalAppDB? = null

        fun getAppDB(context: Context?): LocalAppDB {
            if (INSTANCE == null) {
                synchronized(LocalAppDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context!!.applicationContext,
                        LocalAppDB::class.java,
                        "myDB"
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE as LocalAppDB
        }
    }

}
