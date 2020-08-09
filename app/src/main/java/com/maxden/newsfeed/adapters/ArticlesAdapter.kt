package com.maxden.newsfeed.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.maxden.newsfeed.R
import com.maxden.newsfeed.databinding.ListItemArticleBinding
import com.maxden.newsfeed.db.model.Article

class ArticlesAdapter :
    PagedListAdapter<Article, ArticlesAdapter.ViewHolder>(
        diffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_article, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<Article>() {

            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem == newItem
        }
    }

    inner class ViewHolder(private val binding: ListItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article?) {
            binding.article = article
            article?.run {
                if (!description.isNullOrEmpty()) {
                    binding.contentPreview.text = description
                } else if (!content.isNullOrEmpty()) {
                    binding.contentPreview.text = content
                } else {
                    binding.contentPreview.visibility = View.GONE
                }
            }
            binding.executePendingBindings()
        }
    }
}
