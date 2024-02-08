package ru.tk4dmitriy.data.music.impl

import ru.tk4dmitriy.data.music.api.Music
import ru.tk4dmitriy.data.music.api.MusicRepository
import ru.tk4dmitriy.data.music.impl.mediastore.MusicMediaStore
import ru.tk4dmitriy.core.utils.Extensions.convertToTime
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    private val musicMediaStore: MusicMediaStore
) : MusicRepository {
    override fun fetchMusic(pageSize: Int): List<Music> =
        musicMediaStore(pageSize).musicEntityToMusicDataImpl()

    private fun List<MusicEntity>.musicEntityToMusicDataImpl(): List<Music> = map {
        MusicImpl(
            id = it.id,
            title = it.title,
            artists = it.artists,
            duration = it.duration.convertToTime(),
            uriStr = it.uri.toString()
        )
    }
}