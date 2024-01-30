package com.thanatpp.newsapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thanatpp.newsapp.data.network.response.Articles
import com.thanatpp.newsapp.domain.usecase.NewsArticleListUseCase
import com.thanatpp.newsapp.presentation.adapter.NewsAdapter
import com.thanatpp.newsapp.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    state: SavedStateHandle,
    private val newsArticleListUseCase: NewsArticleListUseCase
) : ViewModel() {

    private var _newsArticle: MutableLiveData<NewsStateModel> =
        state.getLiveData("NEWS_STATE_MODEL")
    val newsArticle: LiveData<NewsStateModel> = _newsArticle

    init {
        fetchNewsArticles()
    }

    private fun fetchNewsArticles() {
        viewModelScope.launch {
            newsArticleListUseCase.invoke()
                .flowOn(Dispatchers.IO)
                .collect { it ->
                    val filteredArticlesAvailable =
                        it.filter { !isInvalidArticles(it.imageUrl) }
                    _newsArticle.value =
                        NewsStateModel(isLoading = false, filteredArticlesAvailable)
                }
        }
    }

    var isInvalidArticles = fun(image: String): Boolean {
        return image.isEmpty()
    }
}