package com.maxden.newsfeed.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maxden.newsfeed.db.dao.ArticlesDao
import com.maxden.newsfeed.db.model.Article

@Database(entities = [Article::class], version = NewsDatabase.VERSION, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    companion object {
        const val VERSION = 1
    }

    abstract fun articlesDao(): ArticlesDao
}