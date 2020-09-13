package com.android.imdb.data.source

import com.android.imdb.data.model.Movie
import com.android.imdb.data.model.SearchResult
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("?apikey=3e974fca&s=batman/")
    fun search(): Observable<SearchResult>

    @GET("/?apikey=3e974fca/")
    fun detail(
        @Query("i") id: String
    ): Observable<Movie>
}