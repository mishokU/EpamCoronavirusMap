package com.example.epamcoronavirusmap.ui.news

import com.example.epamcoronavirusmap.api.Constants.Companion.NEWS_API_DEFAULT_COUNTRY
import com.example.epamcoronavirusmap.api.news.CoronavirusNewsApi
import com.example.epamcoronavirusmap.ui.base.BasePresenter
import com.example.epamcoronavirusmap.utils.SchedulerProviderImpl

class NewsPresenter(
    private val api: CoronavirusNewsApi,
    private val scheduler: SchedulerProviderImpl
) : BasePresenter<NewsContract.View>(), NewsContract.Presenter {

    override fun loadPosts() {
        view?.showProgress()
        subscriptions.add(
            api.getNews(NEWS_API_DEFAULT_COUNTRY)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doFinally { view?.hideProgress() }
                .subscribe(
                    {
                        it?.let {
                            view?.displayPosts(it.news)
                        }
                    }, { ex ->
                        view?.showError(ex.message.toString())
                    }
                )
        )
    }
}