package ru.tk4dmitriy.auramusic

import android.app.Application
import android.content.Context
import ru.tk4dmitriy.auramusic.di.AppComponent
import ru.tk4dmitriy.auramusic.di.DaggerAppComponent

class App : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }
}