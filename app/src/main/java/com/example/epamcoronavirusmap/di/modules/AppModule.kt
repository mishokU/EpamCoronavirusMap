package com.example.epamcoronavirusmap.di.modules

import com.example.epamcoronavirusmap.api.news.CoronavirusNewsApi
import com.example.epamcoronavirusmap.ui.map.MapContract
import com.example.epamcoronavirusmap.ui.map.MapPresenter
import com.example.epamcoronavirusmap.ui.news.NewsContract
import com.example.epamcoronavirusmap.ui.news.NewsPresenter
import com.example.epamcoronavirusmap.utils.SchedulerProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
    Когда вы напишите свои презентеры, нужно будет их написать, как в этом примере
*/

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideMapPresenter(): MapContract.Presenter = MapPresenter()

    @Provides
    @Singleton
    fun provideSchedulerProvider() = SchedulerProviderImpl()

    @Provides
    @Singleton
    fun provideNewsPresenter(
        api: CoronavirusNewsApi,
        scheduler: SchedulerProviderImpl
    ): NewsContract.Presenter = NewsPresenter(api, scheduler)
}