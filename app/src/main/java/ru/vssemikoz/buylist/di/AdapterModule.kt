package ru.vssemikoz.buylist.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.buylist.adapters.BaseAdapter
import ru.vssemikoz.buylist.adapters.ProductAdapter
import ru.vssemikoz.buylist.models.Product

@Module
class AdapterModule {
    @Provides
    fun provideAdapter(adapter: ProductAdapter): BaseAdapter<Product> {
        return adapter
    }
}
