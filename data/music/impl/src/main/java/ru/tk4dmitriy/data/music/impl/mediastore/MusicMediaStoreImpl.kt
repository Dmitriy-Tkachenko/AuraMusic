package ru.tk4dmitriy.data.music.impl.mediastore

import android.provider.MediaStore
import androidx.core.net.toUri
import ru.tk4dmitriy.data.music.impl.MusicEntity
import java.io.File
import javax.inject.Inject

class MusicMediaStoreImpl @Inject constructor(
    private val musicCursor: MusicCursor
) : MusicMediaStore {
    override fun invoke(pageSize: Int): List<MusicEntity> {
        val music: MutableList<MusicEntity> = mutableListOf()
        var processedItemCount = 0
        musicCursor.cursor?.let { cursor ->
            if (cursor.count > 0) {
                val idIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
                val titleIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
                val artistsIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
                val durationIndex = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)
                while (processedItemCount < pageSize) {
                    if (cursor.moveToNext()) {
                        val id = cursor.getLong(idIndex)
                        val uri = getUriById(id = id)
                        music.add(
                            MusicEntity(
                                id = cursor.getLong(idIndex),
                                title = cursor.getString(titleIndex),
                                artists = cursor.getString(artistsIndex),
                                duration = cursor.getLong(durationIndex),
                                uri = uri
                            )
                        )
                        processedItemCount++
                    } else break
                }
            }
        }
        return music
    }

    private fun getUriById(id: Long) =
        (MediaStore.Audio.Media.EXTERNAL_CONTENT_URI.toString() + File.separator + id).toUri()
}