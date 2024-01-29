package ru.tk4dmitriy.data.music.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.tk4dmitriy.data.music.api.Music
import ru.tk4dmitriy.data.music.api.MusicRepository

class MusicRepositoryImpl : MusicRepository {
    override fun fetchMusic(): Flow<List<Music>> = flow {
        val data = getStubData()
        emit(data)
    }

    private fun getStubData(): List<Music> {
        val data: MutableList<Music> = mutableListOf()
        for (i in 0 .. 20) {
            data.add(
                MusicImpl(
                    id = i.toLong(),
                    title = "title $i",
                    artists = "artists $i",
                    duration = "00:00",
                    uriStr = "url"
                )
            )
        }
        return data
    }
}