package com.thanatpp.newsapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Example(
    val Title: String,
    val Detail: String
) : Parcelable