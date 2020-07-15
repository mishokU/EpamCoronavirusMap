package com.example.epamcoronavirusmap.ui.map

import com.example.epamcoronavirusmap.api.map.CountryModel
import com.example.epamcoronavirusmap.ui.base.BaseContract

class MapContract : BaseContract() {

    interface View : BaseContract.View {
        fun showCountriesOnMap(countries: List<CountryModel>)
        fun showCountry(country: String)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onCountryClick(country: String)
        fun loadCountries()
    }
}