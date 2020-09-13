package com.android.imdb.ui.detail

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.android.imdb.data.model.Movie
import com.android.imdb.data.repository.RemoteRepository
import com.android.imdb.data.source.APIResponse
import io.reactivex.rxjava3.disposables.CompositeDisposable


class DetailViewModel @ViewModelInject constructor(
    private val remoteRepository: RemoteRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val movieData = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = movieData
    val isLoading = MutableLiveData<Boolean>()
    private val compositeDisposable = CompositeDisposable()

    fun loadDetail(id: String) {
        showLoading(true)
        remoteRepository.onDetail(compositeDisposable, id, object : APIResponse<Movie> {
            override fun onSuccess(result: Movie?) {
                showLoading(false)
                movieData.value = result
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