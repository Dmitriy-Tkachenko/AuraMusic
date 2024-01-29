package ru.tk4dmitriy.auramusic.di

import dagger.Module
import dagger.Provides
import ru.tk4dmitriy.data.music.impl.MusicRepositoryImpl
import ru.tk4dmitriy.features.music.api.GetMusicFeatureCase
import ru.tk4dmitriy.features.music.impl.GetMusicFeatureCaseImpl
import ru.tk4dmitriy.screens.music.MusicScreenApi
import ru.tk4dmitriy.screens.music.di.MusicComponentDependencies
import ru.tk4dmitriy.screens.music.di.MusicComponentHolder
import javax.inject.Singleton

@Module
class MusicScreenModule {

    @Singleton
    @Provides
    fun provideMusicDependencies(): MusicComponentDependencies {
        return object : MusicComponentDependencies {
            override fun getMusicFeatureCase(): GetMusicFeatureCase = GetMusicFeatureCaseImpl(MusicRepositoryImpl())
        }
    }

    @Provides
    fun provideFeatureMusic(dependencies: MusicComponentDependencies): MusicScreenApi {
        MusicComponentHolder.init(dependencies)
        return MusicComponentHolder.get()
    }
}