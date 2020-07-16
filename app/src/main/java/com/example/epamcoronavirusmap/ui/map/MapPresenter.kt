package com.example.epamcoronavirusmap.ui.map

import com.example.epamcoronavirusmap.api.CoronavirusService
import com.example.epamcoronavirusmap.ui.base.BasePresenter
import com.example.epamcoronavirusmap.ui.countries.CountryResponse
import com.example.epamcoronavirusmap.utils.SchedulerProvider
import timber.log.Timber

class MapPresenter(private val scheduler: SchedulerProvider) : BasePresenter<MapContract.View>(),
    MapContract.Presenter {

    private var onePartOfConfirmed: Int = 1000
    private val smallTotalCases: IntRange = IntRange(0, onePartOfConfirmed)
    private val mediumTotalCases: IntRange = IntRange(onePartOfConfirmed, onePartOfConfirmed * 2)
    private val bigTotalCases: IntRange = IntRange(onePartOfConfirmed * 2, onePartOfConfirmed * 3)
    private val hugeTotalCases: IntRange = IntRange(onePartOfConfirmed * 3, onePartOfConfirmed * 4)

    override fun loadCountries() {
        view?.showProgress()
        subscriptions.add(
            CoronavirusService.retrofitServiceStatistics.getAllCountries()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doFinally { view?.hideProgress() }
                .subscribe({
                    it?.let {
                        distributeCountriesOnCircles(it)
                    }
                }, { ex ->
                    view?.showError(ex.message.toString())
                    Timber.e(ex)
                })
        )
    }

    private fun distributeCountriesOnCircles(countries: List<CountryResponse>) {
        val countriesUi: MutableList<MapUIModel> = mutableListOf()
        for (country in countries) {
            when (country.totalCases) {
                in smallTotalCases -> countriesUi.add(
                    createMapUIModel(country, MapRadius.SMALL, Marker.SMALL_MARKER_COLOR)
                )
                in mediumTotalCases -> countriesUi.add(
                    createMapUIModel(country, MapRadius.MEDIUM, Marker.MEDIUM_MARKER_COLOR)
                )
                in bigTotalCases -> countriesUi.add(
                    createMapUIModel(country, MapRadius.BIG, Marker.BIG_MARKER_COLOR)
                )
                in hugeTotalCases -> countriesUi.add(
                    createMapUIModel(country, MapRadius.HUGE, Marker.HUGE_MARKER_COLOR)
                )
                else -> createMapUIModel(country, MapRadius.HUGE, Marker.HUGE_MARKER_COLOR)
            }
        }
        view?.showCountriesOnMap(countriesUi)
    }

    private fun createMapUIModel(
        country: CountryResponse,
        circle: Pair<Int, Int>,
        markerColor: Float
    ): MapUIModel {
        return MapUIModel(
            countryName = country.countryName!!,
            lat = country.countryInfo?.lat!!,
            lan = country.countryInfo.long,
            mapCircle = circle,
            markerColor = markerColor
        )
    }
}