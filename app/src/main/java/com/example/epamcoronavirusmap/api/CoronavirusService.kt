package com.example.epamcoronavirusmap.api

import com.example.epamcoronavirusmap.api.Constants.Companion.BASE_URL
import com.example.epamcoronavirusmap.api.Constants.Companion.BASE_URL_STATISTICS
import com.example.epamcoronavirusmap.api.map.CoronavirusApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/*
    По хорошему нужно сделать тут сервис, потому что сейчас я пишу через api
 */

val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .client(
        OkHttpClient()
            .newBuilder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(
                        HttpLoggingInterceptor.Level.BODY
                    )
            ).build()
    )
    .build()

val retrofitStatistics: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL_STATISTICS)
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

object CoronavirusService {
    val retrofitServiceStatistics: CoronavirusApi by lazy {
        retrofitStatistics.create(CoronavirusApi::class.java)
    }

    val retrofitService: CoronavirusApi by lazy {
        retrofit.create(CoronavirusApi::class.java)
    }
}
