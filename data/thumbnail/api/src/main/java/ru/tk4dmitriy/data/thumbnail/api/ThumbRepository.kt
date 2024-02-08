package ru.tk4dmitriy.data.thumbnail.api

interface ThumbRepository {
    fun fetchThumb(id: Long, uriStr: String, thumbSize: Pair<Int, Int>) : Thumb
}