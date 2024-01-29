package ru.tk4dmitriy.screens.music.di

import ru.tk4dmitriy.module_injector.ComponentHolder
import ru.tk4dmitriy.screens.music.MusicScreenApi

object MusicComponentHolder : ComponentHolder<MusicScreenApi, MusicComponentDependencies> {
    private var musicComponent: MusicComponent? = null

    override fun init(dependencies: MusicComponentDependencies) {
        if (musicComponent == null) {
            synchronized(MusicComponentHolder::class.java) {
                if (musicComponent == null) {
                    musicComponent = MusicComponent.initAndGet(dependencies = dependencies)
                }
            }
        }
    }

    override fun get(): MusicScreenApi = getComponent()

    internal fun getComponent(): MusicComponent {
        checkNotNull(musicComponent) { "MusicComponent was not initialized!" }
        return musicComponent!!
    }

    override fun reset() {
        musicComponent = null
    }
}