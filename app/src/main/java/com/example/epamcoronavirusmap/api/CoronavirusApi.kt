package com.example.epamcoronavirusmap.api

import io.reactivex.Observable
import retrofit2.http.GET

/*
    Тут вы пишите свои GET запросы, для асинхронности используйте возвращаемый тип Deferred
    Вместо @String сделайте модельки данных из апи
 */

interface CoronavirusApi {

    @GET("test")
    fun getTestData() : Observable<List<String>>
}

