package com.example.epamcoronavirusmap.di.modules

import com.example.epamcoronavirusmap.api.CoronavirusApi
import com.example.epamcoronavirusmap.ui.map.MapContract
import com.example.epamcoronavirusmap.ui.map.MapPresenter
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
    fun provideMapPresenter(
        api : CoronavirusApi,
        scheduler : SchedulerProviderImpl
    ) : MapContract.Presenter = MapPresenter(api, scheduler)

    @Provides
    @Singleton
    fun provideSchedulerProvider() = SchedulerProviderImpl()

}