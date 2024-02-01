package com.thanatpp.newsapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.thanatpp.newsapp.data.db.roommodel.NewsTable

@Dao
interface NewsDao {
    @Query("SELECT * FROM NEWS_TALBE")
    fun getAllArticles(): List<NewsTable>

    @Insert
    fun insertNews(vararg news: NewsTable)

    @Query("SELECT EXISTS(SELECT * FROM NEWS_TALBE WHERE title = :title)")
    fun isExist(title: String): Boolean

    @Query("DELETE FROM NEWS_TALBE WHERE title = :title")
    fun deleteNewsByTitle(title: String)
}
