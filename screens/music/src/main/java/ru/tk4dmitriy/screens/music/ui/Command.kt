package ru.tk4dmitriy.screens.music.ui

import android.net.Uri

sealed class Command {
    class LoadFirstPageMusic(val pageSize: Int) : Command()
    class LoadNextPageMusic(val pageSize: Int) : Command()
    class LoadThumb(val id: Long, val uri: Uri, val thumbSize: Pair<Int, Int>) : Command()
}