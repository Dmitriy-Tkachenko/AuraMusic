package ru.tk4dmitriy.data.music.api

interface Music {
    val id: Long
    val title: String
    val artists: String
    val duration: String
    val uriStr: String
}