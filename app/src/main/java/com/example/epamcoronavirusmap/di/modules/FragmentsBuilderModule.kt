package com.example.epamcoronavirusmap.di.modules


import com.example.epamcoronavirusmap.ui.base.BaseFragment
import com.example.epamcoronavirusmap.ui.map.MapFragment
import com.example.epamcoronavirusmap.ui.news.NewsFragment
import com.example.epamcoronavirusmap.ui.statistics.StatisticsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeBaseFragment(): BaseFragment

    @ContributesAndroidInjector
    abstract fun contributeMapFragment(): MapFragment

    @ContributesAndroidInjector
    abstract fun contributeNewsFragment(): NewsFragment

    @ContributesAndroidInjector
    abstract fun contributeStatisticsFragment(): StatisticsFragment

}