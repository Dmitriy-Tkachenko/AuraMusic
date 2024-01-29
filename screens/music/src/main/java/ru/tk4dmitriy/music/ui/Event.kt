package ru.tk4dmitriy.screens.music.ui

import  ru.tk4dmitriy.screens.music.ItemState

sealed class Event {
    sealed class Ui : Event() {
        object Init : Ui()
    }
    sealed class Internal: Event() {
        data class LoadingSuccess(val data: List<ItemState>) : Internal()
        data class LoadingError(val throwable: Throwable) : Internal()
    }
}