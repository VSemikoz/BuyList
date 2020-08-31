package ru.vssemikoz.buylist.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.buylist.data.CategoryStorage
import ru.vssemikoz.buylist.data.localStorage.LocalProductsStorage
import ru.vssemikoz.buylist.data.ProductStorage
import ru.vssemikoz.buylist.data.localStorage.LocalCategoryStorage

@Module
class StorageModule {
    @Provides
    fun provideProductStorage(productStorage: LocalProductsStorage): ProductStorage {
        return productStorage
    }

    @Provides
    fun provideCategoryStorage(categoryStorage: LocalCategoryStorage): CategoryStorage {
        return categoryStorage
    }
}
