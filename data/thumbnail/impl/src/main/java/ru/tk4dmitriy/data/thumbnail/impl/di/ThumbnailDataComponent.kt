package ru.tk4dmitriy.data.thumbnail.impl.di

import android.content.Context
import dagger.Component
import ru.tk4dmitriy.data.thumbnail.api.ThumbDataApi
import ru.tk4dmitriy.data.thumbnail.api.ThumbRepository

@Component(dependencies = [ThumbnailDataComponentDependencies::class], modules = [ThumbnailDataModule::class])
interface ThumbnailDataComponent : ThumbDataApi {
    fun getContext(): Context
    override fun getThumbRepository(): ThumbRepository

    companion object {
        fun initAndGet(thumbnailDataComponentDependencies: ThumbnailDataComponentDependencies): ThumbDataApi {
            return DaggerThumbnailDataComponent.builder()
                .thumbnailDataComponentDependencies(thumbnailDataComponentDependencies)
                .build()
        }
    }
}