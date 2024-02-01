package com.thanatpp.newsapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thanatpp.newsapp.domain.model.ArticlesModel
import com.thanatpp.newsapp.domain.usecase.AddNewsBookmarkUseCase
import com.thanatpp.newsapp.domain.usecase.IsExistNewsBookmarkUseCase
import com.thanatpp.newsapp.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    private val addNewsBookmarkUseCase: AddNewsBookmarkUseCase,
    private var isExistNewsBookmarkUseCase: IsExistNewsBookmarkUseCase
) : ViewModel() {

    private var _isExistBookmark = SingleLiveEvent<Boolean>()
    val isExistBookmark: LiveData<Boolean> = _isExistBookmark

    fun addToBookmark(articles: ArticlesModel) {
        viewModelScope.launch {
            addNewsBookmarkUseCase.invoke(articles).flowOn(Dispatchers.IO).collect {
                Log.i("TEST", "ADD BOOKMARK SUCCESS")
                _isExistBookmark.value = true
            }
        }
    }

    fun checkIsExistBookmark(articles: ArticlesModel) {
        viewModelScope.launch {
            isExistNewsBookmarkUseCase.invoke(articles)
                .flowOn(Dispatchers.IO)
                .collect {
                    Log.i("TEST", "checkIsExistBookmark $it")
                    _isExistBookmark.value = it
                }
        }
    }
}