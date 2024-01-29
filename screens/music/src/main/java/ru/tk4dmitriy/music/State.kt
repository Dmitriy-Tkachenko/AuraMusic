package ru.tk4dmitriy.screens.music

data class State(
    val loading: Boolean = false,
    val loadingMore: Boolean = false,
    val error: Exception? = null,
    val data: List<ItemState> = emptyList()
)

data class ItemState(
    val id: Long,
    val title: String,
    val artists: String,
    val duration: String
)