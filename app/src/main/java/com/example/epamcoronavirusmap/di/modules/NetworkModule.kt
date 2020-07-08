package com.example.epamcoronavirusmap.di.modules

import com.example.epamcoronavirusmap.api.Constants.Companion.BASE_URL
import com.example.epamcoronavirusmap.api.CoronavirusApi
import com.example.epamcoronavirusmap.api.Constants.Companion.NEWS_API_BASE_URL
import com.example.epamcoronavirusmap.api.moshi
import com.example.epamcoronavirusmap.api.news.CoronavirusNewsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCoronavirusApi(@Named("provideRetrofitInterface") retrofit: Retrofit): CoronavirusApi =
        retrofit.create(CoronavirusApi::class.java)

    @Provides
    @Singleton
    fun provideCoronavirusNewsApi(@Named("provideRetrofitNewsInterface") retrofit: Retrofit): CoronavirusNewsApi =
        retrofit.create(CoronavirusNewsApi::class.java)

    @Provides
    @Singleton
    @Named("provideRetrofitInterface")
    fun provideRetrofitInterface(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @Singleton
    @Named("provideRetrofitNewsInterface")
    fun provideRetrofitNewsInterface(): Retrofit = Retrofit.Builder()
        .baseUrl(NEWS_API_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}