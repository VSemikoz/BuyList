package ru.vssemikoz.buylist.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.vssemikoz.buylist.data.AppDB


@Module
class DataBaseModule {
    @Provides
    fun provideDataBase(context: Context): AppDB {
        return Room.databaseBuilder<AppDB>(
            context,
            AppDB::class.java, "product_data_base"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}
