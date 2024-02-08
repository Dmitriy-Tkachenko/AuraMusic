package ru.tk4dmitriy.screens.music.ui

import android.graphics.Bitmap
import android.net.Uri

data class State(
    val loading: Boolean = false,
    val loadingMore: Boolean = false,
    val fullData: Boolean = false,
    val error: Throwable? = null,
    val data: List<ItemState> = emptyList(),
)

data class ItemState(
    val id: Long,
    val title: String,
    val artists: String,
    val duration: String,
    val thumb: Bitmap? = null,
    val uri: Uri
)