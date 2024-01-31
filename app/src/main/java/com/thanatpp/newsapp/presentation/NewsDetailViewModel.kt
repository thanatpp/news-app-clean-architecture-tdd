package com.thanatpp.newsapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thanatpp.newsapp.data.network.response.Articles
import com.thanatpp.newsapp.domain.model.ArticlesModel
import com.thanatpp.newsapp.domain.usecase.AddNewsBookmarkUseCase
import com.thanatpp.newsapp.domain.usecase.NewsArticleListUseCase
import com.thanatpp.newsapp.presentation.adapter.NewsAdapter
import com.thanatpp.newsapp.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    private val useCase: AddNewsBookmarkUseCase
) : ViewModel() {

    fun addToBookmark(articles: ArticlesModel) {
        viewModelScope.launch {
            useCase.invoke(articles).flowOn(Dispatchers.IO).collect {
                Log.i("TEST", "ADD BOOKMARK SUCCESS")
            }
        }
    }
}