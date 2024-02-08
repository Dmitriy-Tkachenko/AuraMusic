package ru.tk4dmitriy.data.thumbnail.impl

import ru.tk4dmitriy.data.thumbnail.api.Thumb

class ThumbImpl(
    override val id: Long,
    override val thumb: Any?
) : Thumb