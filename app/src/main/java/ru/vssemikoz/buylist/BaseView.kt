package ru.vssemikoz.buylist

interface BaseView<T> {

    fun setPresenter(presenter: T)
}
