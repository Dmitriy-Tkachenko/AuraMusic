package ru.tk4dmitriy.screens.music.ui.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.tk4dmitriy.screens.music.ui.Effect
import ru.tk4dmitriy.screens.music.ui.Event
import ru.tk4dmitriy.screens.music.ui.ItemState
import ru.tk4dmitriy.screens.music.ui.MusicAdapter
import ru.tk4dmitriy.screens.music.ui.State
import vivid.money.elmslie.core.store.Store

class TracksOnScrollListener (
    private val store: Store<Event, Effect, State>,
    private val adapter: ListAdapter<ItemState, MusicAdapter.ViewHolder>,
    private val thumbSize: Pair<Int, Int>
) : RecyclerView.OnScrollListener() {
    private val posLoadedThumbs: HashSet<Int> = hashSetOf()

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val linearLayoutManager = (recyclerView.layoutManager as LinearLayoutManager)
        val visibleItemCount = linearLayoutManager.childCount
        val totalItemCount = linearLayoutManager.itemCount
        val firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()
        val lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()

        loadThumbs(firstVisibleItemPosition, lastVisibleItemPosition)
        loadMore(visibleItemCount, firstVisibleItemPosition, totalItemCount)
    }

    private fun loadThumbs(start: Int, end: Int) {
        for (i in start..end) {
            if (!posLoadedThumbs.contains(i)) {
                posLoadedThumbs.add(i)
                store.accept(
                    Event.Ui.LoadThumb(
                        id = adapter.currentList[i].id,
                        uri = adapter.currentList[i].uri,
                        thumbSize = thumbSize
                    )
                )
            }
        }
    }

    private fun loadMore(
        visibleItemCount: Int,
        firstVisibleItemPosition: Int,
        totalItemCount: Int
    ) {
        if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
            && !store.currentState.fullData && !store.currentState.loadingMore) {
            store.accept(Event.Ui.LoadMore)
        }
    }
}