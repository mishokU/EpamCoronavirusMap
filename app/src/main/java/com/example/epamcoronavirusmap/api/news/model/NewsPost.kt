package com.example.epamcoronavirusmap.api.news.model

data class NewsPost(
    val ampWebUrl: String?,
    val categories: List<String>,
    val cdnAmpWebUrl: String?,
    val excerpt: String,
    val heat: Int,
    val images: List<Image>?,
    val locale: String,
    val path: String,
    val provider: Any,
    val publishedDateTime: String,
    val tags: List<String>,
    val title: String,
    val topics: List<String>,
    val type: String,
    val updatedDateTime: String?,
    val webUrl: String
)