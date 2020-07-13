package com.example.epamcoronavirusmap.di.modules

import com.example.epamcoronavirusmap.ui.map.MapContract
import com.example.epamcoronavirusmap.ui.map.MapPresenter
import com.example.epamcoronavirusmap.ui.statistics.StatisticsContract
import com.example.epamcoronavirusmap.ui.statistics.StatisticsPresenter
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
    fun provideMapPresenter(schedulerProvider: SchedulerProviderImpl)
            : MapContract.Presenter = MapPresenter(schedulerProvider)

    @Provides
    @Singleton
    fun provideStatisticsPresenter(schedulerProvider: SchedulerProviderImpl)
            : StatisticsContract.Presenter = StatisticsPresenter(schedulerProvider)

    @Provides
    @Singleton
    fun provideSchedulerProvider() = SchedulerProviderImpl()

}