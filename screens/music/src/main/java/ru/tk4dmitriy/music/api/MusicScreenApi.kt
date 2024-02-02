package ru.tk4dmitriy.screens.music

import ru.tk4dmitriy.module_injector.BaseAPI

const val TAG = "FRAGMENT_MUSIC"

interface MusicScreenApi : BaseAPI {
    fun getTagFragment(): String = TAG
}
