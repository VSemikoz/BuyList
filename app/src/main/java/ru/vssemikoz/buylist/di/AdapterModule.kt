package ru.vssemikoz.buylist.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.buylist.adapters.BaseAdapter
import ru.vssemikoz.buylist.adapters.CategoryAdapter
import ru.vssemikoz.buylist.adapters.ProductAdapter
import ru.vssemikoz.buylist.adapters.TouchHelperAdapter
import ru.vssemikoz.buylist.models.Category
import ru.vssemikoz.buylist.models.Product

@Module
class AdapterModule {
    @Provides
    fun provideProductAdapter(adapter: ProductAdapter): TouchHelperAdapter<Product> {
        return adapter
    }

    @Provides
    fun provideCategoryAdapter(adapter: CategoryAdapter): BaseAdapter<Category> {
        return adapter
    }
}
