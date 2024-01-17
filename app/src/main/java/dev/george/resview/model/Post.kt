package dev.george.resview.model

import androidx.annotation.DrawableRes

data class Post(
    val id: Int = 0,
    val username: String = "",
    val minute: Int = 0,
    @DrawableRes val avatar: Int?,
    val content: String,
)