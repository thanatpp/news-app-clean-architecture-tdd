package com.thanatpp.newsapp.data.network

import com.thanatpp.newsapp.data.network.response.NewArticlesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String,
    ): NewArticlesResponse

}