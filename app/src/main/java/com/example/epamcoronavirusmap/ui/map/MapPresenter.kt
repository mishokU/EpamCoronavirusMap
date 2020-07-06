package com.example.epamcoronavirusmap.ui.map

import com.example.epamcoronavirusmap.api.CoronavirusApi
import com.example.epamcoronavirusmap.ui.base.BasePresenter
import com.example.epamcoronavirusmap.utils.SchedulerProvider
import timber.log.Timber
import javax.inject.Inject

class MapPresenter @Inject constructor(
    private val api : CoronavirusApi,
    private val scheduler : SchedulerProvider
) : BasePresenter<MapContract.View>(), MapContract.Presenter {

    override fun onCountryClick(country: String) {
        view?.showCountry(country)
    }

    override fun loadCountries() {
        view?.showProgress()
        subscriptions.add(
            api.getTestData()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doFinally { view?.hideProgress() }
                .subscribe ({
                    it?.let { view?.displayCountries(it) }
                }, {ex ->
                    view?.showErrorMessage(ex.message)
                    Timber.e(ex)
                })
        )
    }
}