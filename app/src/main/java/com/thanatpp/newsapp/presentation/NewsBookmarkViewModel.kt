package com.thanatpp.newsapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thanatpp.newsapp.domain.usecase.NewsArticleListDBUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsBookmarkViewModel @Inject constructor(
    private var useCase: NewsArticleListDBUseCase
) : ViewModel() {

    init {
        fetchNewsBookmark()
    }

    fun fetchNewsBookmark() {
        Log.i("TEST", "START fetchNewsBookmark")
        viewModelScope.launch {
            useCase.invoke()
                .flowOn(Dispatchers.IO)
                .collect {
                    Log.i("TEST", "FETCH NEWS BOOKMARK ${it.size}")
                }
        }
    }
}