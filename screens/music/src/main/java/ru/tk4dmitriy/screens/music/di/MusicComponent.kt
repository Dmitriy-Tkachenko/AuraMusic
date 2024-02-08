package ru.tk4dmitriy.screens.music.di

import dagger.Component
import ru.tk4dmitriy.screens.music.api.MusicScreenApi
import ru.tk4dmitriy.screens.music.ui.MusicFragment

@Component(dependencies = [MusicComponentDependencies::class], modules = [MusicModule::class])
@MusicScope
internal abstract class MusicComponent : MusicScreenApi {
    internal abstract fun inject(musicFragment: MusicFragment)

    companion object {
        fun initAndGet(dependencies: MusicComponentDependencies): MusicComponent {
            return DaggerMusicComponent.builder()
                .musicComponentDependencies(dependencies)
                .build()
        }
    }
}
