package ru.tk4dmitriy.data.music.impl

import ru.tk4dmitriy.data.music.api.Music
import android.net.Uri

class MusicEntity(
    val id: Long,
    val title: String,
    val artists: String,
    val duration: Long,
    val uri: Uri
)

class MusicImpl(
    override val id: Long,
    override val title: String,
    override val artists: String,
    override val duration: String,
    override val uriStr: String
) : Music