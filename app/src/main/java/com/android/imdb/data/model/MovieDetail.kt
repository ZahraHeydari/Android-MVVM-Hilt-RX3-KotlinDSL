package com.android.imdb.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetail(
    val id: Long = 1,
    val imdbID: String,
    @Json(name = "Title") val title: String,
    @Json(name = "Year") val year: String,
    @Json(name = "Rated") var rated: String?,
    @Json(name = "Released") var released: String?,
    @Json(name = "Runtime") var runtime: String?,
    @Json(name = "Genre") var genre: String?,
    @Json(name = "Director") var director: String?,
    @Json(name = "Writer") var writer: String?,
    @Json(name = "Actors") var actors: String?,
    @Json(name = "Plot") var plot: String?,
    @Json(name = "Language") var language: String?,
    @Json(name = "Country") var country: String?,
    @Json(name = "Awards") var awards: String?,
    @Json(name = "Poster") val poster: String,
    @Json(name = "Ratings") var ratings: List<Rating>?,
    @Json(name = "Metascore") var metascore: String?,
    var imdbRating: String?,
    var imdbVotes: String?,
    @Json(name = "Type") val type: String,
    @Json(name = "DVD") var dvd: String?,
    @Json(name = "BoxOffice") var boxOffice: String?,
    @Json(name = "TotalSeasons") var totalSeasons: String?,
    @Json(name = "Production") var production: String?,
    @Json(name = "Website") var website: String?,
    @Json(name = "Response") var response: String?,
    @Json(name = "fetched_before") var fetchedBefore: Boolean = false
)