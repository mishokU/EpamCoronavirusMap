package com.example.epamcoronavirusmap.api.news.model

data class Location(
    val countryOrRegion: String,
    val county: String?,
    val isoCode: String,
    val lat: Double,
    val long: Double,
    val provinceOrState: String?
)