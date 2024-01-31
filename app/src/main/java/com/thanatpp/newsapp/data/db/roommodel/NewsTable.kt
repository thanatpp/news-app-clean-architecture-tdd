package com.thanatpp.newsapp.data.db.roommodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thanatpp.newsapp.data.network.response.Articles
import com.thanatpp.newsapp.domain.model.ArticlesModel

@Entity(tableName = "NEWS_TALBE")
data class NewsTable(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "date_time") val dateTime: String
) {
    companion object {
        fun NewsTable.toModel(): ArticlesModel {
            return ArticlesModel(
                title = this.title ?: "",
                description = this.description ?: "",
                imageUrl = this.imageUrl ?: "",
                content = this.content ?: "",
                dateTime = this.dateTime ?: ""
            )
        }
    }
}
