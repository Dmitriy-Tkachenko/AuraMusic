package ru.tk4dmitriy.data.music.impl

import android.net.Uri
import ru.tk4dmitriy.data.music.api.Music

data class MusicEntity(
    val id: Long,
    val title: String,
    val artists: String,
    val duration: Long,
    val uri: Uri
)

data class MusicImpl(
    override val id: Long,
    override val title: String,
    override val artists: String,
    override val duration: String,
    override val uriStr: String
) : Music