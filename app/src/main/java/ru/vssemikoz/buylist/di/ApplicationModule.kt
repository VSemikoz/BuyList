package ru.vssemikoz.buylist.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.vssemikoz.buylist.MainApplication


@Module
class ApplicationModule(val application: MainApplication) {

    @Provides
    fun provideApplication(): MainApplication {
        return application
    }

    @Provides
    fun provideContext(): Context {
        return application.applicationContext
    }
}

