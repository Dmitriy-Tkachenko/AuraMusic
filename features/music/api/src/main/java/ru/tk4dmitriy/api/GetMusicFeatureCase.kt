package ru.tk4dmitriy.features.music.api

import kotlinx.coroutines.flow.Flow

interface GetMusicFeatureCase {
    operator fun invoke(): Flow<List<Music>>
}