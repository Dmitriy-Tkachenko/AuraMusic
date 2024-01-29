package ru.tk4dmitriy.screens.music.di

import dagger.Module
import dagger.Provides
import ru.tk4dmitriy.features.music.api.GetMusicFeatureCase
import ru.tk4dmitriy.screens.music.State
import ru.tk4dmitriy.screens.music.ui.Actor
import ru.tk4dmitriy.screens.music.ui.Effect
import ru.tk4dmitriy.screens.music.ui.Event
import ru.tk4dmitriy.screens.music.ui.Reducer
import vivid.money.elmslie.core.store.Store
import vivid.money.elmslie.coroutines.ElmStoreCompat

@Module
internal class MusicModule {

    @Provides
    @MusicScope
    fun getStore(
        initState: State,
        reducer: Reducer,
        actor: Actor
    ): Store<Event, Effect, State> = ElmStoreCompat(
        initialState = initState,
        reducer = reducer,
        actor = actor
    )

    @Provides
    fun provideReducer(): Reducer = Reducer()

    @Provides
    fun provideState(): State = State()

    @Provides
    fun provideActor(getMusicFeatureCase: GetMusicFeatureCase): Actor = Actor(getMusicFeatureCase)
}