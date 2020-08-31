package ru.vssemikoz.buylist.di

import dagger.Subcomponent
import ru.vssemikoz.buylist.addEditProduct.AddEditProductFragment
import ru.vssemikoz.buylist.categoryList.CategoryListFragment
import ru.vssemikoz.buylist.productLists.ProductListsFragment


@Subcomponent(modules = [
    AdapterModule::class,
    PresenterModule::class,
//    RepositoryModule.class,
    StorageModule::class,
//    IconicStorageModule.class,
    NavigatorModule::class
//    MapperModule.class
])
public interface FragmentComponent {
    fun inject(fragment: ProductListsFragment?)

    fun inject(fragment: AddEditProductFragment?)

    fun inject(fragment: CategoryListFragment?)
}
