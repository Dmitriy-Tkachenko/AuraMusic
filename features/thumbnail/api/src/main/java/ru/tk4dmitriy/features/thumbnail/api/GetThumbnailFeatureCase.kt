package ru.tk4dmitriy.features.thumbnail.api

interface GetThumbnailFeatureCase {
    operator fun invoke(id: Long, uriStr: String, thumbSize: Pair<Int, Int>): Thumb
}