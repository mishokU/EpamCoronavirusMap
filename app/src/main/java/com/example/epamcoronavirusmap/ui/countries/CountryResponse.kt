package com.example.epamcoronavirusmap.ui.countries

data class CountryResponse(
    val active: Int?,
    val cases: Int?,
    val casesPerOneMillion: Int?,
    val country: String?,
    val countryInfo: CountryInfo?,
    val critical: Int?,
    val deaths: Int?,
    val deathsPerOneMillion: Float?,
    val recovered: Int?,
    val tests: Int?,
    val testsPerOneMillion: Int?,
    val todayCases: Int?,
    val todayDeaths: Int?,
    val updated: Long?
)

data class CountryInfo(
    val _id: Int?,
    val flag: String?,
    val iso2: String?,
    val iso3: String?,
    val lat: Float?,
    val long: Float?
)
