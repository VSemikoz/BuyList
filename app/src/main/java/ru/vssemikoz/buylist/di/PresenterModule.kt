package ru.vssemikoz.buylist.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.buylist.addEditProduct.AddEditProductContract
import ru.vssemikoz.buylist.addEditProduct.AddEditProductPresenter
import ru.vssemikoz.buylist.productLists.ProductListsContract
import ru.vssemikoz.buylist.productLists.ProductListsPresenter

@Module
class PresenterModule {
    @Provides
    fun provideProductListPresenter(presenter: ProductListsPresenter): ProductListsContract.Presenter {
        return presenter
    }

    @Provides
    fun provideAddEditPresenter(presenter: AddEditProductPresenter): AddEditProductContract.Presenter {
        return presenter
    }
}
