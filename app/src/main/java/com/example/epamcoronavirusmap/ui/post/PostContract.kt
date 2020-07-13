package com.example.epamcoronavirusmap.ui.post

import com.example.epamcoronavirusmap.ui.base.BaseContract

interface PostContract {

    interface Presenter : BaseContract.Presenter<PostContract.View> {}

    interface View : BaseContract.View {}
}