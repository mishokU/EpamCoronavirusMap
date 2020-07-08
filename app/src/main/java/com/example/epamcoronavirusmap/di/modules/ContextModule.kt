package com.example.epamcoronavirusmap.di.modules

import android.content.Context
import com.example.epamcoronavirusmap.ui.main.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ContextModule {

    @Provides
    @Singleton
    fun provideMainApplication(context: Context): MainApplication =
        context.applicationContext as MainApplication
}