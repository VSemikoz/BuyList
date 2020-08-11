package ru.vssemikoz.buylist.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.buylist.utils.navigator.Navigator
import ru.vssemikoz.buylist.utils.navigator.NavigatorImpl

@Module
class NavigatorModule {
    @Provides
    fun provideNewsFeedPresenter(navigatorImpl: NavigatorImpl): Navigator {
        return navigatorImpl
    }
}
