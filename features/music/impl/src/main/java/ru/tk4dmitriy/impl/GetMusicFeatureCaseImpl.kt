package ru.tk4dmitriy.features.music.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.tk4dmitriy.features.music.api.GetMusicFeatureCase
import ru.tk4dmitriy.features.music.api.Music
import ru.tk4dmitriy.data.music.api.MusicRepository
import javax.inject.Inject

class GetMusicFeatureCaseImpl @Inject constructor(
    private val musicRepository: MusicRepository
) : GetMusicFeatureCase {
    override fun invoke(): Flow<List<Music>> =
        musicRepository.fetchMusic().map { result ->
            result.map {
                Music(
                    id = it.id,
                    title = it.title,
                    artists = it.artists,
                    duration = it.duration,
                    uriStr = it.uriStr
                )
            }
        }
}