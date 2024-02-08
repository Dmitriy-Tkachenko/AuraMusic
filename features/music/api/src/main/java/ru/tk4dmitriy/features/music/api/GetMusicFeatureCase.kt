package ru.tk4dmitriy.features.music.api

interface GetMusicFeatureCase {
    operator fun invoke(pageSize: Int): List<Music>
}