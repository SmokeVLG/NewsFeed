package com.maxden.newsfeed.db.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)