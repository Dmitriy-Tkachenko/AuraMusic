package ru.tk4dmitriy.screens.music.ui

import android.graphics.Bitmap
import android.net.Uri

sealed class Event {
    sealed class Ui : Event() {
        object Init : Ui()
        object Refresh : Ui()
        object LoadMore : Ui()
        class LoadThumb(val id: Long, val uri: Uri, val thumbSize: Pair<Int, Int>) : Ui()
    }
    sealed class Internal: Event() {
        data class LoadingFirstPageSuccess(val data: List<ItemState>) : Internal()
        data class LoadingNextPageSuccess(val data: List<ItemState>) : Internal()
        data class LoadingThumbSuccess(val data: Pair<Long, Bitmap>) : Internal()
        data class LoadingError(val throwable: Throwable) : Internal()
    }
}