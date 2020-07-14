package com.example.epamcoronavirusmap.api.news.model

data class NewsInfo(
    val location: Location,
    val updatedDateTime: String,
    val news: List<NewsPost>
)