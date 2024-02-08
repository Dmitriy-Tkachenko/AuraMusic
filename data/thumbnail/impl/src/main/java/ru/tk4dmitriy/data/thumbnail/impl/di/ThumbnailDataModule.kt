package ru.tk4dmitriy.data.thumbnail.impl.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.tk4dmitriy.data.thumbnail.api.ThumbRepository
import ru.tk4dmitriy.data.thumbnail.impl.ThumbRepositoryImpl
import ru.tk4dmitriy.data.thumbnail.impl.thumbnailRecipient.ThumbnailRecipient
import ru.tk4dmitriy.data.thumbnail.impl.thumbnailRecipient.ThumbnailRecipientImpl

@Module
class ThumbnailDataModule {

    @Provides
    fun provideThumbnailRecipient(
        context: Context
    ): ThumbnailRecipient = ThumbnailRecipientImpl(context)

    @Provides
    fun provideThumbnailRepository(
        thumbnailRecipient: ThumbnailRecipient
    ): ThumbRepository = ThumbRepositoryImpl(thumbnailRecipient)
}