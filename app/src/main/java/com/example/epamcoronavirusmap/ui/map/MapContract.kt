package com.example.epamcoronavirusmap.ui.map

import com.example.epamcoronavirusmap.ui.base.BaseContract

class MapContract : BaseContract() {

    interface View : BaseContract.View {
        fun showCountriesOnMap(countries: List<MapUIModel>)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadCountries()
    }
}