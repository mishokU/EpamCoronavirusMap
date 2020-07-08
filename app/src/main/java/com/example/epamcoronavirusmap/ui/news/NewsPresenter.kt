package com.example.epamcoronavirusmap.ui.news

import com.example.epamcoronavirusmap.api.Constants.Companion.NEWS_API_DEFAULT_COUNTRY
import com.example.epamcoronavirusmap.api.news.CoronavirusNewsApi
import com.example.epamcoronavirusmap.api.news.model.NewsInfo
import com.example.epamcoronavirusmap.domain.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.await

typealias NewsResult = Result<NewsInfo?>

class NewsPresenter(private val api: CoronavirusNewsApi) {

    private var coroutineScope = CoroutineScope(Dispatchers.Main + Job())
    private var result: NewsResult = Result.Loading
    private lateinit var view: NewsView

    init {
        loadNews()
    }

    fun onBind(view: NewsView) {
        this.view = view
    }

    private fun loadNews() {
        coroutineScope.launch {
            val dataAsync = api.getNews(NEWS_API_DEFAULT_COUNTRY)
            try {
                val data = dataAsync.await()
                updateView { Result.Loading }
                data?.let {
                    updateView { Result.Success(it) }
                }
            } catch (e: Exception) {
                updateView { Result.Error(e) }
            }
        }
    }

    private fun updateView(mapper: NewsResult.() -> NewsResult) {
        result = result.mapper()
        view.update(result)
    }
}