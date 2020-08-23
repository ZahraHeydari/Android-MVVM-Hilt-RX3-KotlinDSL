package com.android.imdb.data.model

data class Movie(
    val id: Long = 1,
    val imdbID: String,
    val title: String,
    val year: String,
    val type: String,
    val poster: String,
    var fetchedBefore: Boolean = false
)