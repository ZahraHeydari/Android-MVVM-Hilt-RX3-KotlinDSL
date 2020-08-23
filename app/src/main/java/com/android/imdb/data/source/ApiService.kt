package com.android.imdb.data.source

import com.android.imdb.data.model.Movie
import com.android.imdb.data.model.SearchResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(".")
    fun search(
        @Query("apiKey") apiKey: String = "3e974fca",
        @Query("s") s: String
    ): Response<SearchResult>

    @GET(".")
    fun getMovieDetail(
        @Query("apiKey") apiKey: String = "3e974fca",
        @Query("i") id: String
    ): Response<Movie>
}