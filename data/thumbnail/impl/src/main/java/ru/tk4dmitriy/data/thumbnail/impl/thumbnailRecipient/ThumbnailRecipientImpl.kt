package ru.tk4dmitriy.data.thumbnail.impl.thumbnailRecipient

import android.content.Context
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Build
import android.util.Size
import java.io.FileNotFoundException
import javax.inject.Inject

class ThumbnailRecipientImpl @Inject constructor(
    private val context: Context
): ThumbnailRecipient {
    override fun getThumbnail(uri: Uri, reqWidth: Int, reqHeight: Int): Bitmap? {
        val retriever = MediaMetadataRetriever()
        val imageDecoder = ImageDecoder()
        var thumbnail: Bitmap? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            try {
                thumbnail = context.contentResolver.loadThumbnail(uri, Size(reqWidth, reqHeight), null)
            } catch (_: FileNotFoundException) { }
        } else {
            retriever.setDataSource(context, uri)
            retriever.embeddedPicture?.let { bytes ->
                thumbnail = imageDecoder.decodeSampledBitmapFromByteArray(
                    data = bytes, reqWidth = reqWidth, reqHeight = reqHeight
                )
            }
        }
        return thumbnail
    }
}