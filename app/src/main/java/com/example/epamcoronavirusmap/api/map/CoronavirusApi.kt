package com.example.epamcoronavirusmap.api.map

import com.example.epamcoronavirusmap.api.histogram.DailyCountryStatistics
import com.example.epamcoronavirusmap.ui.countries.CountryResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/*
    Тут вы пишите свои GET запросы, для асинхронности используйте возвращаемый тип Deferred
    Вместо @String сделайте модельки данных из апи
 */

interface CoronavirusApi {

    @GET("/summary")
    fun getGlobalCountriesData(): Observable<SummaryModel>

    @GET("/dayone/country/{country}/status/confirmed")
    fun getCountryInfo(@Path("country") country: String): Observable<List<DailyCountryStatistics>>

    @GET("countries?yesterday&sort")
    fun getAllCountries(): Observable<List<CountryResponse>>

}

