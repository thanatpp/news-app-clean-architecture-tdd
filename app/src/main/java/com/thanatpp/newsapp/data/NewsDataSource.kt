package com.thanatpp.newsapp.data

import com.thanatpp.newsapp.data.db.NewsDao
import com.thanatpp.newsapp.data.db.roommodel.NewsTable
import com.thanatpp.newsapp.data.network.NewsApi
import com.thanatpp.newsapp.data.network.response.NewArticlesResponse
import javax.inject.Inject

interface DataSource {
    suspend fun getNewsArticles(
        country: String,
        category: String,
        apiKey: String
    ): NewArticlesResponse

    suspend fun getNewsArticlesFromDB(): List<NewsTable>
    suspend fun insertNews(news: NewsTable)
    suspend fun isHasNews(title: String): Boolean
}

class NewsDataSource @Inject constructor(
    private var newsApi: NewsApi,
    private var newsDao: NewsDao
) : DataSource {
    override suspend fun getNewsArticles(
        country: String,
        category: String,
        apiKey: String
    ): NewArticlesResponse {
        return newsApi.getNewsArticles(country, category, apiKey)
    }

    override suspend fun getNewsArticlesFromDB(): List<NewsTable> {
        return newsDao.getAllArticles()
    }

    override suspend fun insertNews(news: NewsTable) {
        return newsDao.insertNews(news)
    }

    override suspend fun isHasNews(title: String): Boolean {
        return newsDao.isExist(title)
    }
}