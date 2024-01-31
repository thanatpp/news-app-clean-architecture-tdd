package com.thanatpp.newsapp.domain.usecase

import android.util.Log
import com.thanatpp.newsapp.data.NewsRepository
import com.thanatpp.newsapp.domain.model.ArticlesModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddNewsBookmarkUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(articlesModel: ArticlesModel): Flow<Boolean> = flow {
        Log.i("test", "invoke insetNewsDB()")
        repository.insetNewsDB(articlesModel).also { emit(true) }
    }
}


