package com.thanatpp.newsapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Example(
    val title: String,
    val detail: String
) : Parcelable