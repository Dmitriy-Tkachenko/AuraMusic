package ru.tk4dmitriy.screens.music.ui

import ru.tk4dmitriy.screens.music.State
import vivid.money.elmslie.core.store.dsl_reducer.DslReducer

class Reducer : DslReducer<Event, State, Effect, Command>() {
    override fun Result.reduce(event: Event) = when (event) {
        is Event.Internal.LoadingSuccess -> {
            state { copy(loading = false, data = event.data) }
        }
        is Event.Internal.LoadingError -> {
            state { copy(loading = false) }
        }
        Event.Ui.Init -> {
          if (state == State()) {
                state { copy(loading = true) }
                commands { +Command.LoadMusic }
          } else { }
        }
    }
}