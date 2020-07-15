package com.example.epamcoronavirusmap.ui.map

enum class TotalConfirmedCircle {
    SMALL, MEDIUM, BIG, HUGE
}

data class MapUIModel(
    val countryName: String,
    val lan: Int,
    val lat: Int,
    val mapCircle: TotalConfirmedCircle
)
