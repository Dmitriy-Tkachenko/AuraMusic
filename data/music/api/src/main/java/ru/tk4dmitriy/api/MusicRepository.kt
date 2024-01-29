package ru.tk4dmitriy.data.music.api

import kotlinx.coroutines.flow.Flow

interface MusicRepository {
    fun fetchMusic() : Flow<List<Music>>
}