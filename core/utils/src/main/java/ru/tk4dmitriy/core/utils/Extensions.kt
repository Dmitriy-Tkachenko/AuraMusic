package ru.tk4dmitriy.core.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

object Extensions {
    @SuppressLint("SimpleDateFormat")
    fun Long.convertToTime(): String = SimpleDateFormat("mm:ss").format(Date(this))
}