package com.example.epamcoronavirusmap.api.news

import com.example.epamcoronavirusmap.api.Constants.Companion.NEWS_API_SUBSCRIPTION_KEY
import com.example.epamcoronavirusmap.api.news.model.NewsInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CoronavirusNewsApi {

    @Headers(
        "Subscription-key: $NEWS_API_SUBSCRIPTION_KEY"
    )
    @GET("news/{location}")
    fun getNews(@Path("location") location: String): Call<NewsInfo?>
}