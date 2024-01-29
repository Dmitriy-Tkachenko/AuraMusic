package ru.tk4dmitriy.auramusic.di

import android.content.Context
import ru.tk4dmitriy.auramusic.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return App.appContext
    }
}