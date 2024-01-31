package com.thanatpp.newsapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thanatpp.newsapp.domain.usecase.NewsArticleListDBUseCase
import com.thanatpp.newsapp.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsBookmarkViewModel @Inject constructor(
    private var useCase: NewsArticleListDBUseCase
) : ViewModel() {

    private var _newsArticle = SingleLiveEvent<NewsStateModel>()
    val newsArticle: LiveData<NewsStateModel> = _newsArticle

    fun fetchNewsBookmark() {
        Log.i("TEST", "START fetchNewsBookmark")
        viewModelScope.launch {
            useCase.invoke()
                .flowOn(Dispatchers.IO)
                .collect {
                    _newsArticle.value =
                        NewsStateModel(isLoading = false, it.reversed())
                }
        }
    }
}