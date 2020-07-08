package com.example.epamcoronavirusmap.api

import com.example.epamcoronavirusmap.api.Constants.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/*
    По хорошему нужно сделать тут сервис, потому что сейчас я пишу через api
 */

val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

object CoronavirusService {
    val retrofitService: CoronavirusApi by lazy {
        retrofit.create(CoronavirusApi::class.java)
    }
}