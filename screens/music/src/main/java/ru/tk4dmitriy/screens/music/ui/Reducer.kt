package ru.tk4dmitriy.screens.music.ui

import vivid.money.elmslie.core.store.dsl_reducer.DslReducer

class Reducer : DslReducer<Event, State, Effect, Command>() {
    private val firstPageSize = 60
    private val nextPageSize = 30
    override fun Result.reduce(event: Event) = synchronized(state) {
        when (event) {
            is Event.Internal.LoadingFirstPageSuccess -> {
                state { copy(loading = false, data = event.data) }
            }
            is Event.Internal.LoadingNextPageSuccess -> {
                if (event.data.isNotEmpty())
                    state { copy(loadingMore = false, data = state.data + event.data ) }
                else state { copy(loadingMore = false, fullData = true) }
            }
            is Event.Internal.LoadingThumbSuccess -> {
                val newData = state.data.map { itemState ->
                    if (itemState.id == event.data.first)
                        itemState.copy(thumb = event.data.second)
                    else itemState
                }
                state { copy(data = newData) }
            }
            is Event.Internal.LoadingError -> {
                state { copy(loading = false) }
            }

            Event.Ui.Init -> {
                if (state.data.isEmpty()) {
                    state { copy(loading = true) }
                    commands { +Command.LoadFirstPageMusic(firstPageSize) }
                }
            }
            Event.Ui.Refresh -> {

            }
            Event.Ui.LoadMore -> {
                state { copy(loadingMore = true) }
                commands { +Command.LoadNextPageMusic(nextPageSize) }
            }
            is Event.Ui.LoadThumb -> {
                commands { +Command.LoadThumb(id = event.id, uri = event.uri, thumbSize = event.thumbSize) }
            }
        }
    }
}