package com.example.epamcoronavirusmap.ui.histogram

import com.example.epamcoronavirusmap.api.Constants
import com.example.epamcoronavirusmap.api.CoronavirusService
import com.example.epamcoronavirusmap.api.histogram.DailyCountryStatistics
import com.example.epamcoronavirusmap.ui.base.BasePresenter
import com.example.epamcoronavirusmap.utils.SchedulerProvider
import timber.log.Timber
import java.text.SimpleDateFormat

class DailyStatisticsPresenter(
    private val scheduler: SchedulerProvider
) : BasePresenter<DailyStatisticsContract.View>(), DailyStatisticsContract.Presenter {

    override fun loadStatistics(country: String) {
        view?.showProgress()
        subscriptions.add(
            CoronavirusService.retrofitService.getCountryInfo(Constants.DEFAULT_STATISTICS_COUNTRY)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doFinally { view?.hideProgress() }
                .subscribe({
                    val lists = processGrowthData(it)
                    view?.setBarChartData(lists.first, lists.second)
                }, { ex ->
                    view?.showError(ex.message.toString())
                    Timber.e(ex)
                })
        )
    }

    fun processGrowthData(data: List<DailyCountryStatistics>): Pair<List<Float>, List<String>> {
        val growth = mutableListOf<Float>()
        growth.add(data.first().cases.toFloat())
        for (i in 1..(data.size - 1)) {
            growth.add((data[i].cases - data[i - 1].cases).toFloat())
        }

        val dates = data.map {
            val parser = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'")
            val formatter = SimpleDateFormat("dd.MM")
            val output = formatter.format(parser.parse(it.date))
            output
        }

        return Pair(growth, dates)
    }
}
