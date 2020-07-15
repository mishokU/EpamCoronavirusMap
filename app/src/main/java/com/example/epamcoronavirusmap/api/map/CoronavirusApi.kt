package com.example.epamcoronavirusmap.api.map

import io.reactivex.Observable
import retrofit2.http.GET

/*
    Тут вы пишите свои GET запросы, для асинхронности используйте возвращаемый тип Deferred
    Вместо @String сделайте модельки данных из апи
 */

interface CoronavirusApi {

    @GET("/summary")
    fun getGlobalCountriesData(): Observable<SummaryModel>
}
