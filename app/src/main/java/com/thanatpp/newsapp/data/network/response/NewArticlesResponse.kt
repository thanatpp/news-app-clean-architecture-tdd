package com.thanatpp.newsapp.data.network.response

data class NewArticlesResponse(
    var status: String,
    var totalResults: Int,
    var articles: ArrayList<Articles>,
)