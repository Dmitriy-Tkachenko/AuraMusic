package ru.tk4dmitriy.screens.music.ui.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.tk4dmitriy.screens.music.R

class TrackItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.bottom = view.resources.getDimension(R.dimen.space_vert).toInt()
    }
}