package ru.tk4dmitriy.data.music.impl.mediastore

import ru.tk4dmitriy.data.music.impl.MusicEntity

interface MusicMediaStore {
    operator fun invoke(pageSize: Int): List<MusicEntity>
}