package ru.tk4dmitriy.data.music.impl.mediastore

import android.database.Cursor
import android.net.Uri

interface MusicCursor {
    val uri: Uri
    val projection: Array<out String>?
    val selection : String?
    val selectionArgs : Array<out String>?
    val sortOrder : String?
    val cursor: Cursor?
}