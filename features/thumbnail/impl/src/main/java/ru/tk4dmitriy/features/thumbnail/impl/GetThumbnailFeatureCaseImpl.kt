package ru.tk4dmitriy.features.thumbnail.impl

import ru.tk4dmitriy.data.thumbnail.api.ThumbRepository
import ru.tk4dmitriy.features.thumbnail.api.GetThumbnailFeatureCase
import ru.tk4dmitriy.features.thumbnail.api.Thumb
import javax.inject.Inject

class GetThumbnailFeatureCaseImpl @Inject constructor(
    private val thumbnailRepository: ThumbRepository
): GetThumbnailFeatureCase {
    override fun invoke(id: Long, uriStr: String, thumbSize: Pair<Int, Int>): Thumb {
        val data = thumbnailRepository.fetchThumb(id = id, uriStr = uriStr, thumbSize = thumbSize)
        return Thumb(data.id, data.thumb)
    }
}