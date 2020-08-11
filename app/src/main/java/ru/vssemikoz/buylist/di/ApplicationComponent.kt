package ru.vssemikoz.buylist.di

import dagger.Component
import ru.vssemikoz.buylist.MainApplication


@Component(modules = [ApplicationModule::class, DataBaseModule::class])
interface ApplicationComponent {

    fun inject(mainApplication: MainApplication)

    fun fragmentComponent(): FragmentComponent

}
