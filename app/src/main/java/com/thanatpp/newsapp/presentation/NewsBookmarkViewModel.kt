package com.thanatpp.newsapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thanatpp.newsapp.domain.model.ArticlesModel
import com.thanatpp.newsapp.domain.usecase.DeleteNewsBookmarkUseCase
import com.thanatpp.newsapp.domain.usecase.NewsArticleListDBUseCase
import com.thanatpp.newsapp.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsBookmarkViewModel @Inject constructor(
    private var newsArticleListDBUseCase: NewsArticleListDBUseCase,
    private var deleteNewsBookmarkUseCase: DeleteNewsBookmarkUseCase
) : ViewModel() {

    private var _newsArticle = SingleLiveEvent<NewsStateModel>()
    val newsArticle: LiveData<NewsStateModel> = _newsArticle

    fun fetchNewsBookmark() {
        Log.i("TEST", "START fetchNewsBookmark")
        viewModelScope.launch {
            newsArticleListDBUseCase.invoke()
                .flowOn(Dispatchers.IO)
                .collect {
                    _newsArticle.value =
                        NewsStateModel(isLoading = false, it.reversed())
                }
        }
    }

    fun deleteNewsBookmark(articles: ArticlesModel) {
        Log.i("TEST", "START deleteNewsBookmark")
        viewModelScope.launch {
            deleteNewsBookmarkUseCase.invoke(articles)
                .flowOn(Dispatchers.IO)
                .collect {
                    fetchNewsBookmark()
                }
        }
    }
}