package ru.tk4dmitriy.data.thumbnail.impl.thumbnailRecipient

import android.graphics.Bitmap
import android.net.Uri

interface ThumbnailRecipient {
    fun getThumbnail(uri: Uri, reqWidth: Int, reqHeight: Int): Bitmap?
}