package com.maxden.newsfeed.api

import com.maxden.newsfeed.db.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface NewsService {
    @Headers("X-Api-Key: 26eddb253e7840f988aec61f2ece2907")
    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("page") page: Int = 1,
        @QueryMap parameters: Map<String, String> = mapOf("country" to "ru")
    ): NewsResponse
}