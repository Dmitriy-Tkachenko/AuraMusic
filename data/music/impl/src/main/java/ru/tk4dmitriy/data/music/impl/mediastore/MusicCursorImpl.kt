package ru.tk4dmitriy.data.music.impl.mediastore

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import javax.inject.Inject

class MusicCursorImpl @Inject constructor(context: Context) : MusicCursor {
    override val uri: Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
    override val projection: Array<out String> = arrayOf(
        MediaStore.Audio.Media._ID,
        MediaStore.Audio.Media.TITLE,
        MediaStore.Audio.Media.ARTIST,
        MediaStore.Audio.Media.DURATION
    )
    override val selection: String = MediaStore.Audio.Media.IS_MUSIC + " = 1"
    override val selectionArgs: Array<out String>? = null
    override val sortOrder: String = MediaStore.Audio.Media.TITLE + " ASC"

    override val cursor: Cursor? = context.applicationContext.contentResolver
        .query(uri, projection, selection, selectionArgs, sortOrder)
}