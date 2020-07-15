package com.example.epamcoronavirusmap.ui.map

import com.example.epamcoronavirusmap.api.CoronavirusService
import com.example.epamcoronavirusmap.api.map.CountryModel
import com.example.epamcoronavirusmap.ui.base.BasePresenter
import com.example.epamcoronavirusmap.utils.SchedulerProvider
import timber.log.Timber

class MapPresenter(private val scheduler: SchedulerProvider) : BasePresenter<MapContract.View>(),
    MapContract.Presenter {

    private var onePartOfConfirmed: Int? = null

    override fun onCountryClick(country: String) {
        view?.showCountry(country)
    }

    override fun loadCountries() {
        view?.showProgress()
        subscriptions.add(
            CoronavirusService.retrofitService.getGlobalCountriesData()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doFinally { view?.hideProgress() }
                .subscribe({
                    it?.let {
                        calculateOnePartFromMaxConfirmed(it.Countries)
                        distributeCountriesOnCircles(it.Countries)
                    }
                }, { ex ->
                    view?.showError(ex.message.toString())
                    Timber.e(ex)
                })
        )
    }

    private fun calculateOnePartFromMaxConfirmed(countries: List<CountryModel>) {
        val maxTotalConfirmed = countries.maxBy {
            it.TotalConfirmed
        }
        onePartOfConfirmed = maxTotalConfirmed?.TotalConfirmed?.div(5)
    }

    private fun distributeCountriesOnCircles(countries: List<CountryModel>) {
        val countriesUi: MutableList<MapUIModel> = mutableListOf()
        for (country in countries) {

        }
    }
}