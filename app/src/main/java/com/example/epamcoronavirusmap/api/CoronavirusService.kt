package com.example.epamcoronavirusmap.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

/*
    По хорошему нужно сделать тут сервис, потому что сейчас я пишу через api
 */

val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

object CoronavirusService {

}