package com.maxden.newsfeed.repository

import com.maxden.newsfeed.db.model.Article
import com.maxden.newsfeed.repository.Listing

interface NewsRepository {
    fun getTopHeadlines(): Listing<Article>
}
