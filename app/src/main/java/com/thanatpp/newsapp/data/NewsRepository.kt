package com.thanatpp.newsapp.data

import com.thanatpp.newsapp.data.network.response.Articles
import com.thanatpp.newsapp.data.network.response.Articles.Companion.toModel
import com.thanatpp.newsapp.data.network.response.NewArticlesResponse
import com.thanatpp.newsapp.domain.model.ArticlesModel
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private var dataSource: NewsDataSource
) {
    suspend fun getNewsArticles(): List<ArticlesModel> {
        val response = dataSource.getNewsArticles(
            country = "us",
            category = "general",
            apiKey = "fa3deec2cb9847099a35dfde2bd3424b"
        )
        return response.articles.map { it.toModel() }
    }
}