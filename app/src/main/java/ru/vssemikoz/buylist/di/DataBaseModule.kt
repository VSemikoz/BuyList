package ru.vssemikoz.buylist.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.vssemikoz.buylist.data.localStorage.LocalAppDB


@Module
class DataBaseModule {
    @Provides
    fun provideDataBase(context: Context): LocalAppDB {
        return Room.databaseBuilder<LocalAppDB>(
            context,
            LocalAppDB::class.java, "product_data_base"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}
