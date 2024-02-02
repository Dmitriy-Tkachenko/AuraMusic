package ru.tk4dmitriy.screens.music.ui

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.tk4dmitriy.features.music.api.GetMusicFeatureCase
import ru.tk4dmitriy.screens.music.ItemState
import vivid.money.elmslie.coroutines.Actor
import javax.inject.Inject

class Actor @Inject constructor(
    private val loadMusicUseCase: GetMusicFeatureCase
) : Actor<Command, Event> {
    override fun execute(command: Command): Flow<Event> = when (command) {
        is Command.LoadMusic -> {
            flow {
                loadMusicUseCase().collect { music ->
                    val itemStates: MutableList<ItemState> = mutableListOf()
                    music.forEach {
                        itemStates.add(
                            ItemState(
                                id = it.id,
                                title = it.title,
                                artists = it.artists,
                                duration = it.duration
                            )
                        )
                    }
                    emit(itemStates)
                }
            }.mapEvents(Event.Internal::LoadingSuccess, Event.Internal::LoadingError)
        }
    }
}