package ru.tk4dmitriy.auramusic.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.tk4dmitriy.data.music.api.MusicDataApi
import ru.tk4dmitriy.data.music.impl.di.MusicDataComponent
import ru.tk4dmitriy.data.music.impl.di.MusicDataComponentDependencies
import ru.tk4dmitriy.data.thumbnail.api.ThumbDataApi
import ru.tk4dmitriy.data.thumbnail.impl.di.ThumbnailDataComponent
import ru.tk4dmitriy.data.thumbnail.impl.di.ThumbnailDataComponentDependencies
import ru.tk4dmitriy.features.music.api.GetMusicFeatureCase
import ru.tk4dmitriy.features.music.impl.GetMusicFeatureCaseImpl
import ru.tk4dmitriy.features.thumbnail.api.GetThumbnailFeatureCase
import ru.tk4dmitriy.features.thumbnail.impl.GetThumbnailFeatureCaseImpl
import ru.tk4dmitriy.screens.music.api.MusicScreenApi
import ru.tk4dmitriy.screens.music.di.MusicComponentDependencies
import ru.tk4dmitriy.screens.music.di.MusicComponentHolder
import javax.inject.Singleton

@Module
class MusicScreenModule {
    @Provides
    fun provideMusicDataComponentDependencies(context: Context): MusicDataComponentDependencies {
        return object : MusicDataComponentDependencies {
            override fun getContext(): Context = context
        }
    }

    @Provides
    fun provideMusicDataComponent(dependencies: MusicDataComponentDependencies): MusicDataApi {
        return MusicDataComponent.initAndGet(dependencies)
    }

    @Singleton
    @Provides
    fun provideMusicDependencies(musicDataApi: MusicDataApi, thumbDataApi: ThumbDataApi): MusicComponentDependencies {
        return object : MusicComponentDependencies {
            override fun getMusicFeatureCase(): GetMusicFeatureCase = GetMusicFeatureCaseImpl(musicDataApi.getMusicRepository())
            override fun getThumbFeatureCase(): GetThumbnailFeatureCase = GetThumbnailFeatureCaseImpl(thumbDataApi.getThumbRepository())
        }
    }

    @Provides
    fun provideFeatureMusic(dependencies: MusicComponentDependencies): MusicScreenApi {
        MusicComponentHolder.init(dependencies)
        return MusicComponentHolder.get()
    }

    @Provides
    fun provideThumbnailDataComponentDependencies(context: Context): ThumbnailDataComponentDependencies {
        return object : ThumbnailDataComponentDependencies {
            override fun getContext(): Context = context
        }
    }

    @Provides
    fun provideThumbnailDataComponent(dependencies: ThumbnailDataComponentDependencies) : ThumbDataApi {
        return ThumbnailDataComponent.initAndGet(dependencies)
    }
}