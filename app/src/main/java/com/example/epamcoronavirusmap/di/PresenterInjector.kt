package com.example.epamcoronavirusmap.di

import android.app.Application
import com.example.epamcoronavirusmap.di.modules.ActivityModule
import com.example.epamcoronavirusmap.di.modules.AppModule
import com.example.epamcoronavirusmap.di.modules.ContextModule
import com.example.epamcoronavirusmap.di.modules.NetworkModule
import com.example.epamcoronavirusmap.ui.base.BaseView
import com.example.epamcoronavirusmap.ui.main.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    ActivityModule::class,
    AppModule::class,
    NetworkModule::class]
)
interface AppComponent : AndroidInjector<MainApplication> {

    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param mapPresenter PostPresenter in which to inject the dependencies
     */
    override fun inject(application : MainApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}