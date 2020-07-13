package com.example.epamcoronavirusmap.ui.news

import com.example.epamcoronavirusmap.api.news.model.NewsPost
import com.example.epamcoronavirusmap.ui.base.BaseContract

interface NewsContract {

    interface Presenter : BaseContract.Presenter<NewsContract.View> {
        fun loadPosts()
        fun onItemClick(url: String)
    }

    interface View : BaseContract.View {
        fun displayPosts(posts: List<NewsPost>)
        fun showPostFragment(url: String)
    }
}