package ru.tk4dmitriy.data.music.impl.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.tk4dmitriy.data.music.api.MusicRepository
import ru.tk4dmitriy.data.music.impl.MusicRepositoryImpl
import ru.tk4dmitriy.data.music.impl.mediastore.MusicCursor
import ru.tk4dmitriy.data.music.impl.mediastore.MusicCursorImpl
import ru.tk4dmitriy.data.music.impl.mediastore.MusicMediaStore
import ru.tk4dmitriy.data.music.impl.mediastore.MusicMediaStoreImpl

@Module
class MusicDataModule {
    @Provides
    fun provideMusicCursor(context: Context): MusicCursor =
        MusicCursorImpl(context)

    @Provides
    fun provideMusicMediaStore(musicCursor: MusicCursor): MusicMediaStore =
        MusicMediaStoreImpl(musicCursor)

    @Provides
    fun provideMusicRepository(mediaStore: MusicMediaStore): MusicRepository =
        MusicRepositoryImpl(mediaStore)
}