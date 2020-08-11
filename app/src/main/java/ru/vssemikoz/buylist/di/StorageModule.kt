package ru.vssemikoz.buylist.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.buylist.data.LocalProductsStorage
import ru.vssemikoz.buylist.data.ProductStorage

@Module
class StorageModule {
    @Provides
    fun provideStorage(newsStorage: LocalProductsStorage): ProductStorage {
        return newsStorage
    }
}
