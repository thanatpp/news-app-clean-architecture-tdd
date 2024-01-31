package com.thanatpp.newsapp.domain.usecase

import android.util.Log
import com.thanatpp.newsapp.data.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class IsExistNewsBookmarkUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(title: String): Flow<Boolean> = flow {
        Log.i("test", "invoke isHasNews()")
        repository.isHasNews(title).also { emit(it) }
    }
}


