package ru.tk4dmitriy.screens.music.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.tk4dmitriy.screens.music.ui.utils.TrackItemDecoration
import ru.tk4dmitriy.screens.music.di.MusicComponentHolder
import ru.tk4dmitriy.screens.music.databinding.FragmentMusicBinding
import ru.tk4dmitriy.screens.music.ui.utils.TracksOnScrollListener
import ru.tk4dmitriy.screens.music.R
import vivid.money.elmslie.android.base.ElmFragment
import vivid.money.elmslie.core.store.Store
import javax.inject.Inject

class MusicFragment : ElmFragment<Event, Effect, State>() {
    private lateinit var binding: FragmentMusicBinding
    private val adapter: MusicAdapter by lazy { MusicAdapter() }

    @Inject
    lateinit var elmStoreCompat: Store<Event, Effect, State>

    override val initEvent: Event = Event.Ui.Init

    override fun createStore(): Store<Event, Effect, State> = elmStoreCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MusicComponentHolder.getComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMusicBinding.inflate(inflater, container, false)
        binding.rvTracks.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = this@MusicFragment.adapter
            addItemDecoration(TrackItemDecoration())
        }
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        if (requireActivity().isFinishing) {
            MusicComponentHolder.reset()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val thumbWH = resources.getDimension(R.dimen.track_img_wh).toInt()
        val thumbSize = Pair(thumbWH, thumbWH)
        binding.rvTracks.addOnScrollListener(TracksOnScrollListener(store, adapter, thumbSize))
    }

    override fun render(state: State) {
        if (state.loading)
        else if (state.loadingMore)
        else if (state.error != null) stateErrorViewsVisibility()
        else if (state.data.isEmpty()) stateSuccessEmptyViewsVisibility()
        else {
            stateSuccessViewsVisibility()
            adapter.submitList(state.data)
        }
    }

    private fun stateErrorViewsVisibility() {
        binding.llTracks.visibility = View.GONE
        binding.tvEmpty.visibility = View.GONE
        binding.tvError.visibility = View.VISIBLE
    }

    private fun stateSuccessEmptyViewsVisibility() {
        binding.llTracks.visibility = View.GONE
        binding.tvError.visibility = View.GONE
        binding.tvEmpty.visibility = View.VISIBLE
    }

    private fun stateSuccessViewsVisibility() {
        binding.tvEmpty.visibility = View.GONE
        binding.tvError.visibility = View.GONE
        binding.llTracks.visibility = View.VISIBLE
    }
}