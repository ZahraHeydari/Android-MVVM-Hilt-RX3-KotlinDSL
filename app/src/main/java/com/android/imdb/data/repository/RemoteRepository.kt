package com.android.imdb.data.repository

import com.android.imdb.data.model.Movie
import com.android.imdb.data.model.MovieDetail
import com.android.imdb.data.model.SearchResult
import com.android.imdb.data.source.APIResponse
import com.android.imdb.data.source.APIService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val apiService: APIService) {


    fun onSearch(
        compositeDisposable: CompositeDisposable,
        onResponse: APIResponse<SearchResult>
    ): io.reactivex.rxjava3.disposables.Disposable {
        return apiService.search()
            .subscribeOn(io.reactivex.rxjava3.schedulers.Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onResponse.onSuccess(it)
            }, {
                it.printStackTrace()
                onResponse.onError(it)
            }).also {
                compositeDisposable.add(it)
            }

    }


    fun onDetail(
        compositeDisposable: CompositeDisposable,
        id: String,
        onResponse: APIResponse<MovieDetail>
    ): io.reactivex.rxjava3.disposables.Disposable {
        return apiService.detail(id)
            .subscribeOn(io.reactivex.rxjava3.schedulers.Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onResponse.onSuccess(it)
            }, {
                it.printStackTrace()
                onResponse.onError(it)
            }).also {
                compositeDisposable.add(it)
            }

    }

}