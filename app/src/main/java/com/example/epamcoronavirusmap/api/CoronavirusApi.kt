package com.example.epamcoronavirusmap.api

import com.example.epamcoronavirusmap.api.histogram.DailyCountryStatistics
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/*
    Тут вы пишите свои GET запросы, для асинхронности используйте возвращаемый тип Deferred
    Вместо @String сделайте модельки данных из апи
 */

interface CoronavirusApi {

    @GET("/summary")
    fun getTestData(): Observable<List<String>>

    @GET("/dayone/country/{country}/status/confirmed")
    fun getCountryInfo(@Path("country") country: String): Observable<List<DailyCountryStatistics>>
}

