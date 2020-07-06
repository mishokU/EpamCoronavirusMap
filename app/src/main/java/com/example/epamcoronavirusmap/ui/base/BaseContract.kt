package com.example.epamcoronavirusmap.ui.base

abstract class BaseContract {

    interface View : BaseView

    interface Presenter<in V>{
        fun unsubscribe()
        fun attach(view : V)
    }
}