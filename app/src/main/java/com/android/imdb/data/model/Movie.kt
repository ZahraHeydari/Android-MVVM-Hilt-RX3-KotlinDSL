package com.android.imdb.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie(
    val id: Long = 1,
    val imdbID: String,
    @Json(name = "Title") val title: String,
    @Json(name = "Year") val year: String,
    @Json(name = "Type") val type: String,
    @Json(name = "Poster") val poster: String,
    @Json(name = "fetched_before") var fetchedBefore: Boolean = false
)