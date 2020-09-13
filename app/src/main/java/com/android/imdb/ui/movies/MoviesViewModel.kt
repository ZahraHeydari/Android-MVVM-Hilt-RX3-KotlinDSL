package com.android.imdb.ui.movies

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.android.imdb.data.model.SearchResult
import com.android.imdb.data.repository.RemoteRepository
import com.android.imdb.data.source.APIResponse
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MoviesViewModel @ViewModelInject constructor(private val remoteRepository: RemoteRepository) : ViewModel() {

    private val searchResultData = MutableLiveData<SearchResult>()
    val searchResult: LiveData<SearchResult> = searchResultData
    val isLoading = MutableLiveData<Boolean>()
    private val compositeDisposable = CompositeDisposable()


    fun loadMovies() {
        showLoading(true)
        remoteRepository.onSearch(compositeDisposable, object : APIResponse<SearchResult> {
            override fun onSuccess(result: SearchResult?) {
                showLoading(false)
                searchResultData.value = result
            }

            override fun onError(t: Throwable) {
                showLoading(false)
                t.printStackTrace()
            }
        })
    }

    private fun showLoading(isVisible: Boolean) {
        isLoading.value = isVisible
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}