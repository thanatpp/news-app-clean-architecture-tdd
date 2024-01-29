package com.thanatpp.newsapp.presentation

import com.thanatpp.newsapp.domain.model.ArticlesModel

data class NewsStateModel (
    val isLoading: Boolean = true,
    val articleList: List<ArticlesModel> = emptyList(),
    val error: String? = null,
)