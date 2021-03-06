package com.example.epamcoronavirusmap.di.modules


import com.example.epamcoronavirusmap.ui.histogram.DailyStatisticsFragment
import com.example.epamcoronavirusmap.ui.map.MapFragment
import com.example.epamcoronavirusmap.ui.news.NewsFragment
import com.example.epamcoronavirusmap.ui.post.PostFragment
import com.example.epamcoronavirusmap.ui.splash.SplashScreen
import com.example.epamcoronavirusmap.ui.statistics.StatisticsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMapFragment(): MapFragment

    @ContributesAndroidInjector
    abstract fun contributeSplashScreenFragment(): SplashScreen

    @ContributesAndroidInjector
    abstract fun contributeStatisticsFragment(): StatisticsFragment

    @ContributesAndroidInjector
    abstract fun contributeDailyStatisticsFragment(): DailyStatisticsFragment

    @ContributesAndroidInjector
    abstract fun contributeNewsFragment(): NewsFragment

    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostFragment
}