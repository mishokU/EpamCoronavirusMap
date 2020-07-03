package com.example.epamcoronavirusmap.di.modules

import com.example.epamcoronavirusmap.api.BASE_URL
import com.example.epamcoronavirusmap.api.CoronavirusApi
import com.example.epamcoronavirusmap.api.moshi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCoronavirusApi(retrofit: Retrofit) : CoronavirusApi
            = retrofit.create(CoronavirusApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofitInterface() : Retrofit
        = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}