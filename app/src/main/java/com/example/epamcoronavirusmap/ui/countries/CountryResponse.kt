package com.example.epamcoronavirusmap.ui.countries

import com.example.epamcoronavirusmap.api.map.CountryInfo
import com.squareup.moshi.Json

data class CountryResponse(
    @Json(name = "active")
    val activeCases: Int?,

    @Json(name = "cases")
    val totalCases: Int?,

    val casesPerOneMillion: Int?,

    @Json(name = "country")
    val countryName: String?,

    @Json(name = "deaths")
    val totalDeaths: Int?,

    @Json(name = "recovered")
    val recoveredCases: Int?,

    val tests: Int?,
    val testsPerOneMillion: Int?,
    val todayCases: Int?,
    val todayDeaths: Int?,
    val countryInfo: CountryInfo?
)
