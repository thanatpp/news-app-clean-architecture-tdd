package com.thanatpp.newsapp.data

import com.thanatpp.newsapp.data.db.roommodel.NewsTable.Companion.toModel
import com.thanatpp.newsapp.data.network.response.Articles
import com.thanatpp.newsapp.data.network.response.Articles.Companion.toModel
import com.thanatpp.newsapp.data.network.response.NewArticlesResponse
import com.thanatpp.newsapp.domain.model.ArticlesModel
import com.thanatpp.newsapp.domain.model.ArticlesModel.Companion.toNewsTable
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

    suspend fun getNewsArticlesDB(): List<ArticlesModel> {
        return dataSource.getNewsArticlesFromDB().map { it.toModel() }
    }

    suspend fun insetNewsDB(articles: ArticlesModel) {
        return dataSource.insertNews(articles.toNewsTable())
    }
}