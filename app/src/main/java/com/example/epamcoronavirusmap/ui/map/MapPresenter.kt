package com.example.epamcoronavirusmap.ui.map

import com.example.epamcoronavirusmap.api.CoronavirusService
import com.example.epamcoronavirusmap.ui.base.BasePresenter
import com.example.epamcoronavirusmap.utils.SchedulerProvider
import timber.log.Timber

class MapPresenter(private val scheduler: SchedulerProvider) : BasePresenter<MapContract.View>(),
    MapContract.Presenter {

    override fun onCountryClick(country: String) {
        view?.showCountry(country)
    }

    override fun loadCountries() {
        view?.showProgress()
        subscriptions.add(
            CoronavirusService.retrofitService.getTestData()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doFinally { view?.hideProgress() }
                .subscribe({
                    it?.let {
                        view?.displayCountries(it)
                    }
                }, { ex ->
                    view?.showError(ex.message.toString())
                    Timber.e(ex)
                })
        )
    }
}