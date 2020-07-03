package com.example.epamcoronavirusmap.di.utils

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class CoroutineScopeIO

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class CoroutineScopeMain
