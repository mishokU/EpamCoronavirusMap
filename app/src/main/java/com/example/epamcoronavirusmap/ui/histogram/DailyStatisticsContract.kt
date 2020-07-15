package com.example.epamcoronavirusmap.ui.histogram

import com.example.epamcoronavirusmap.ui.base.BaseContract

class DailyStatisticsContract : BaseContract() {

    interface View : BaseContract.View {
        fun setBarChartData(growth: List<Float>, date: List<String>)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadStatistics(country: String)
    }
}
