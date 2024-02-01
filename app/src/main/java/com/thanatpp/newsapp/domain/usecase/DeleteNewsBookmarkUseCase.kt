package com.thanatpp.newsapp.domain.usecase

import com.thanatpp.newsapp.data.NewsRepository
import com.thanatpp.newsapp.domain.model.ArticlesModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteNewsBookmarkUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(articlesModel: ArticlesModel): Flow<Boolean> = flow {
        repository.deleteNews(articlesModel).also { emit(it) }
    }
}


