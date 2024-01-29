package ru.tk4dmitriy.auramusic.di

import ru.tk4dmitriy.auramusic.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ContextModule::class, MusicScreenModule::class])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
}