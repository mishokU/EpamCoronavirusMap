package com.example.epamcoronavirusmap.di.modules

import com.example.epamcoronavirusmap.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentsBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity

}