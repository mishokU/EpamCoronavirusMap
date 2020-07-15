package com.example.epamcoronavirusmap.ui.statistics

import com.example.epamcoronavirusmap.ui.base.BaseContract
import com.example.epamcoronavirusmap.ui.countries.CountryResponse

interface StatisticsContract {

    interface Presenter : BaseContract.Presenter<View> {
        fun loadPosts()
    }

    interface View : BaseContract.View {
        fun displayPosts(posts: List<CountryResponse>)
    }
}