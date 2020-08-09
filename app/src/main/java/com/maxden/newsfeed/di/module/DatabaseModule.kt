package com.maxden.newsfeed.di.module

import android.app.Application
import androidx.room.Room
import com.maxden.newsfeed.db.NewsDatabase
import com.maxden.newsfeed.db.dao.ArticlesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    private lateinit var database: NewsDatabase

    @Singleton
    @Provides
    fun providesDatabase(application: Application): NewsDatabase {
        database = Room.databaseBuilder(application, NewsDatabase::class.java, "news-db").build()
        return database
    }

    @Singleton
    @Provides
    fun providesArticlesDao(database: NewsDatabase): ArticlesDao = database.articlesDao()

}