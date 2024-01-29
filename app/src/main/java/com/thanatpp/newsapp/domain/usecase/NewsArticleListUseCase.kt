package com.thanatpp.newsapp.domain.usecase

import android.util.Log
import com.thanatpp.newsapp.data.NewsRepository
import com.thanatpp.newsapp.data.network.response.Articles
import com.thanatpp.newsapp.domain.model.ArticlesModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsArticleListUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(): Flow<List<ArticlesModel>> = flow {
        Log.d("test", "invoke()")
        repository.getNewsArticles().also { emit(it) }
    }
}


