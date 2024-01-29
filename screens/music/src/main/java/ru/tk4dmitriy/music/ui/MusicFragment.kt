package ru.tk4dmitriy.screens.music.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.tk4dmitriy.screens.music.State
import ru.tk4dmitriy.screens.music.di.MusicComponentHolder
import ru.tk4dmitriy.screens.music.databinding.FragmentMusicBinding
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
        }
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        if (requireActivity().isFinishing) {
            MusicComponentHolder.reset()
        }
    }

    override fun render(state: State) {
        if (state.loading) binding.progress.visibility = View.VISIBLE
        else if (state.error != null) Log.d("MusicFragment", state.error.message.toString())
        else {
            binding.progress.visibility = View.INVISIBLE
            binding.frameLayout.visibility = View.GONE
            adapter.submitList(state.data)
        }
    }
}