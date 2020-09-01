package ru.vssemikoz.buylist.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.buylist.addEditCategoryDialog.AddEditCategoryContract
import ru.vssemikoz.buylist.addEditCategoryDialog.AddEditCategoryDialogPresenter
import ru.vssemikoz.buylist.addEditProduct.AddEditProductContract
import ru.vssemikoz.buylist.addEditProduct.AddEditProductPresenter
import ru.vssemikoz.buylist.categoryList.CategoryListContract
import ru.vssemikoz.buylist.categoryList.CategoryListPresenter
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

    @Provides
    fun provideCategoryListPresenter(presenter: CategoryListPresenter): CategoryListContract.Presenter {
        return presenter
    }

    @Provides
    fun provideAddEditCategoryPresenter(presenter: AddEditCategoryDialogPresenter): AddEditCategoryContract.Presenter {
        return presenter
    }
}
