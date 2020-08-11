package ru.vssemikoz.buylist.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.buylist.productLists.ProductListsContract
import ru.vssemikoz.buylist.productLists.ProductListsPresenter

@Module
class PresenterModule {
    @Provides
    fun provideNewsFeedPresenter(presenter: ProductListsPresenter): ProductListsContract.Presenter {
        return presenter
    }
}
