package ru.vssemikoz.buylist

import android.app.Application
import ru.vssemikoz.buylist.di.ApplicationComponent
import ru.vssemikoz.buylist.di.ApplicationModule
import ru.vssemikoz.buylist.di.DaggerApplicationComponent

class MainApplication: Application() {

    companion object{

        private lateinit var applicationComponent: ApplicationComponent
        private lateinit var instance: MainApplication

        fun getInstance(): MainApplication? {
            return instance
        }

        fun getApplicationComponent(): ApplicationComponent {
            return applicationComponent
        }

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(instance))
            .build()
    }

}
