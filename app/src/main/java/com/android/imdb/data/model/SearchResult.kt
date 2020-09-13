package com.android.imdb.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResult(@Json(name = "Search") val search: List<Movie>)