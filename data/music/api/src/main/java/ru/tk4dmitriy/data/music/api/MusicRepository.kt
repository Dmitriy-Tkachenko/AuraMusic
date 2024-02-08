package ru.tk4dmitriy.data.music.api
interface MusicRepository {
    fun fetchMusic(pageSize: Int) : List<Music>
}