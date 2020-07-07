package com.example.epamcoronavirusmap.api.news.model

data class Image(
    val attribution: String?,
    val height: Int,
    val isCached: Boolean,
    val title: String,
    val url: String,
    val width: Int
)