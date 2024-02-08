package ru.tk4dmitriy.screens.music.ui

import android.graphics.Bitmap
import android.net.Uri
import androidx.core.net.toUri
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.tk4dmitriy.features.music.api.GetMusicFeatureCase
import ru.tk4dmitriy.features.thumbnail.api.GetThumbnailFeatureCase
import vivid.money.elmslie.coroutines.Actor
import javax.inject.Inject
class Actor @Inject constructor(
    private val loadMusicFeatureCase: GetMusicFeatureCase,
    private val loadThumbFeatureCase: GetThumbnailFeatureCase
) : Actor<Command, Event> {
    override fun execute(command: Command): Flow<Event> = when (command) {
        is Command.LoadFirstPageMusic -> loadMusic(command.pageSize, isFirstPage = true)
        is Command.LoadNextPageMusic -> loadMusic(command.pageSize, isFirstPage = false)
        is Command.LoadThumb -> loadThumb(id = command.id, uri = command.uri, thumbSize = command.thumbSize)
    }

    private fun loadMusic(pageSize: Int, isFirstPage: Boolean): Flow<Event> = flow {
        val itemStates = loadMusicFeatureCase(pageSize = pageSize).map {
            ItemState(
                id = it.id,
                title = it.title,
                artists = it.artists,
                duration = it.duration,
                uri = it.uriStr.toUri()
            )
        }
        emit(itemStates)
    }.mapEvents(
        when(isFirstPage) {
            true -> Event.Internal::LoadingFirstPageSuccess
            false -> Event.Internal::LoadingNextPageSuccess
        }, Event.Internal::LoadingError
    )

    private fun loadThumb(id: Long, uri: Uri, thumbSize: Pair<Int, Int>) = flow {
        val data = loadThumbFeatureCase(id = id, uriStr = uri.toString(), thumbSize = thumbSize)
        if (data.thumb != null) {
            val thumb = data.thumb as Bitmap
            emit(Pair(data.id, thumb))
        }
    }.mapEvents(Event.Internal::LoadingThumbSuccess, Event.Internal::LoadingError)
}