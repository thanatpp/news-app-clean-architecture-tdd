package com.thanatpp.newsapp.domain.usecase

import android.util.Log
import com.thanatpp.newsapp.data.NewsRepository
import com.thanatpp.newsapp.domain.model.ArticlesModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class IsExistNewsBookmarkUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(articles: ArticlesModel): Flow<Boolean> = flow {
        Log.i("test", "invoke isHasNews()")
        repository.isHasNews(articles).also { emit(it) }
    }
}


