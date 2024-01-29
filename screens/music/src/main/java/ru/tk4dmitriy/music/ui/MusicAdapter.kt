package ru.tk4dmitriy.screens.music.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.tk4dmitriy.screens.music.ItemState
import ru.tk4dmitriy.screens.music.databinding.ItemTrackBinding

class MusicAdapter : ListAdapter<ItemState, MusicAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemTrackBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding = itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item = item)
    }


    inner class ViewHolder(private val itemBinding: ItemTrackBinding): RecyclerView.ViewHolder(itemBinding.root) {

        fun bind (item: ItemState) = with(itemBinding) {
            name.text = item.title
            artist.text = item.artists
            duration.text = item.duration
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<ItemState>() {
        override fun areItemsTheSame(oldItem: ItemState, newItem: ItemState): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemState, newItem: ItemState): Boolean {
            return oldItem == newItem
        }
    }
}