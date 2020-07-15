package com.example.epamcoronavirusmap.api.map

data class SummaryModel(
    val Global: GlobalInfoModel,
    val Countries: List<CountryModel>
)