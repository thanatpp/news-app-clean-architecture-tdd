package com.thanatpp.newsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thanatpp.newsapp.data.db.roommodel.NewsTable

@Database(
    entities = [NewsTable::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase()  {
    abstract fun newsDao(): NewsDao
}
