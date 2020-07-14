package com.example.epamcoronavirusmap.ui.statistics

import com.example.epamcoronavirusmap.api.CoronavirusService
import com.example.epamcoronavirusmap.ui.base.BasePresenter
import com.example.epamcoronavirusmap.utils.SchedulerProviderImpl


class StatisticsPresenter(
    private val scheduler: SchedulerProviderImpl
) : BasePresenter<StatisticsContract.View>(), StatisticsContract.Presenter {

    override fun loadPosts() {
        view?.showProgress()
        subscriptions.add(
            CoronavirusService.retrofitServiceStatistics.getAllCountries()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doFinally { view?.hideProgress() }
                .subscribe(
                    {
                        it?.let {
                            view?.displayPosts(it)
                        }
                    }, { ex ->
                        view?.showError(ex.message.toString())
                    }
                )
        )
    }
}