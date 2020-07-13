package com.example.epamcoronavirusmap.di

import com.example.epamcoronavirusmap.di.modules.ActivityModule
import com.example.epamcoronavirusmap.di.modules.AppModule
import com.example.epamcoronavirusmap.di.modules.NetworkModule
import com.example.epamcoronavirusmap.ui.main.MainApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        ActivityModule::class,
        AppModule::class,
        NetworkModule::class]
)
interface FragmentComponent : AndroidInjector<MainApplication> {


}