package com.thanatpp.newsapp.data

import com.thanatpp.newsapp.data.network.NewsApi
import com.thanatpp.newsapp.data.network.response.NewArticlesResponse
import javax.inject.Inject

interface DataSource {
    suspend fun getNewsArticles(
        country: String,
        category: String,
        apiKey: String
    ): NewArticlesResponse
}

class NewsDataSource @Inject constructor(
    private var newsApi: NewsApi
) : DataSource {
    override suspend fun getNewsArticles(
        country: String,
        category: String,
        apiKey: String
    ): NewArticlesResponse {
        return newsApi.getNewsArticles(country, category, apiKey)
    }
}