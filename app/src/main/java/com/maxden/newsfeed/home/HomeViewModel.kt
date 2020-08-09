package com.maxden.newsfeed.home

import androidx.lifecycle.ViewModel
import com.maxden.newsfeed.db.model.Article
import com.maxden.newsfeed.repository.Listing
import com.maxden.newsfeed.repository.MainRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(var repository: MainRepository) : ViewModel() {

    private var repoResult: Listing<Article> = repository.getTopHeadlines()

    val posts = repoResult.pagedList
    val networkState = repoResult.networkState
    val refreshState = repoResult.refreshState

    fun refresh() {
        repoResult.refresh.invoke()
    }

    fun retry() {
        repoResult.retry.invoke()
    }

}