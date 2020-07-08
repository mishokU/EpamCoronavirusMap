package com.example.epamcoronavirusmap.ui.base

interface BaseView {
    fun showProgress()
    fun hideProgress()
    fun showError(error: String)
}