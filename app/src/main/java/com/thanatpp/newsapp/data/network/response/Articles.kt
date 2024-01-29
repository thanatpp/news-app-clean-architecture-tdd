package com.thanatpp.newsapp.data.network.response

import android.os.Parcelable
import com.thanatpp.newsapp.domain.model.ArticlesModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Articles(
    var source: Source,
    var author: String,
    var title: String?,
    var description: String?,
    var url: String,
    var urlToImage: String?,
    var publishedAt: String,
    var content: String,
) : Parcelable {
    companion object {
        fun Articles.toModel(): ArticlesModel {
            return ArticlesModel(
                title = this.title ?: "",
                description = this.description ?: "",
                imageUrl = this.urlToImage ?: ""
            )
        }
    }
}