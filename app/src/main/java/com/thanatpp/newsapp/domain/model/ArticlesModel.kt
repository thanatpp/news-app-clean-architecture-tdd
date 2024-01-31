package com.thanatpp.newsapp.domain.model

import android.os.Parcelable
import com.thanatpp.newsapp.data.db.roommodel.NewsTable
import com.thanatpp.newsapp.data.network.response.Articles
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticlesModel(
    var title: String,
    var description: String,
    var imageUrl: String,
    var content: String,
    var dateTime: String,
) : Parcelable {
    companion object {
        fun ArticlesModel.toNewsTable(): NewsTable {
            return NewsTable(
                null,
                title = this.title,
                description = this.description,
                imageUrl = this.imageUrl,
                content = this.content,
                dateTime = this.dateTime
            )
        }
    }
}
