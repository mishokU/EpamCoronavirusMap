package com.example.epamcoronavirusmap.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/*
    Тут вы пишите свои GET запросы, для асинхронности используйте возвращаемый тип Deferred
    Вместо @String сделайте модельки данных из апи
 */

interface CoronavirusApi {

    @GET("test")
    fun getTestData() : Deferred<List<String>>
}

