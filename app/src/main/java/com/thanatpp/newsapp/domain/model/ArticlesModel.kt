package com.thanatpp.newsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticlesModel(
    var title: String,
    var description: String,
    var imageUrl: String,
    var content: String,
) : Parcelable
