package ru.tk4dmitriy.data.music.impl.di

import android.content.Context
import ru.tk4dmitriy.data.music.api.MusicDataApi
import ru.tk4dmitriy.data.music.api.MusicRepository
import ru.tk4dmitriy.data.music.impl.mediastore.MusicCursor
import ru.tk4dmitriy.data.music.impl.mediastore.MusicMediaStore
import dagger.Component

@Component(dependencies = [MusicDataComponentDependencies::class], modules = [MusicDataModule::class])
interface MusicDataComponent : MusicDataApi {
    fun getContext(): Context
    fun getMusicCursor(): MusicCursor
    fun getMusicMedaStore(): MusicMediaStore
    override fun getMusicRepository(): MusicRepository

    companion object {
        fun initAndGet(musicDataComponentDependencies: MusicDataComponentDependencies): MusicDataApi {
            return DaggerMusicDataComponent.builder()
                .musicDataComponentDependencies(musicDataComponentDependencies)
                .build()
        }
    }
}