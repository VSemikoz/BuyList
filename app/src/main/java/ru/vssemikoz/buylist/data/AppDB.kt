package ru.vssemikoz.buylist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.vssemikoz.buylist.models.Product

@Database(entities = [Product::class], version = 2, exportSchema = false)
abstract class AppDB : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {

        private var INSTANCE: AppDB? = null

        fun getAppDB(context: Context?): AppDB {
            if (INSTANCE == null) {
                synchronized(AppDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context!!.applicationContext,
                        AppDB::class.java,
                        "myDB"
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE as AppDB
        }
    }

}
