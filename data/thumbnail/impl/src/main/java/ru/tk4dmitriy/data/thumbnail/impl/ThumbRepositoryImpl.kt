package ru.tk4dmitriy.data.thumbnail.impl

import androidx.core.net.toUri
import ru.tk4dmitriy.data.thumbnail.api.Thumb
import ru.tk4dmitriy.data.thumbnail.api.ThumbRepository
import ru.tk4dmitriy.data.thumbnail.impl.thumbnailRecipient.ThumbnailRecipient
import javax.inject.Inject

class ThumbRepositoryImpl @Inject constructor(
    private val thumbnailRecipient: ThumbnailRecipient
) : ThumbRepository {
    override fun fetchThumb(id: Long, uriStr: String, thumbSize: Pair<Int, Int>): Thumb {
        val thumb = thumbnailRecipient.getThumbnail(
            uri = uriStr.toUri(),
            reqWidth = thumbSize.first,
            reqHeight = thumbSize.second)
        return ThumbImpl(id, thumb)
    }
}