package com.example.epamcoronavirusmap.di.modules

import com.example.epamcoronavirusmap.ui.map.MapContract
import com.example.epamcoronavirusmap.api.CoronavirusApi
import com.example.epamcoronavirusmap.api.news.CoronavirusNewsApi
import com.example.epamcoronavirusmap.ui.map.MapPresenter
import com.example.epamcoronavirusmap.utils.SchedulerProviderImpl
import com.example.epamcoronavirusmap.ui.news.NewsPresenter
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
    fun provideNewsPresenter(api: CoronavirusNewsApi): NewsPresenter = NewsPresenter(api)
}