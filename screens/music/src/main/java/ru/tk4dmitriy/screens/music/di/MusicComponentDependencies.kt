package ru.tk4dmitriy.screens.music.di

import ru.tk4dmitriy.features.music.api.GetMusicFeatureCase
import ru.tk4dmitriy.features.thumbnail.api.GetThumbnailFeatureCase
import ru.tk4dmitriy.module_injector.BaseDependencies

interface MusicComponentDependencies : BaseDependencies {
    fun getMusicFeatureCase(): GetMusicFeatureCase
    fun getThumbFeatureCase(): GetThumbnailFeatureCase
}