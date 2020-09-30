package com.android.imdb.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android.imdb.R
import com.android.imdb.data.model.Movie
import com.android.imdb.databinding.HolderMovieItemBinding
import kotlin.properties.Delegates

class MoviesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mMovieList: List<Movie> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderPostBinding =
            HolderMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(holderPostBinding)
    }

    override fun getItemCount(): Int = mMovieList.size

    private fun getItem(position: Int) = mMovieList[position]


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostViewHolder).onBind(getItem(position))
    }

    inner class PostViewHolder(private val holderPostBinding: HolderMovieItemBinding) :
        RecyclerView.ViewHolder(holderPostBinding.root) {

        fun onBind(movie: Movie) {

            with(holderPostBinding) {
                movieTitleTextView.text = movie.title
                movieYearTextView.text = movie.year

                movieImageView.load(movie.poster) {
                    error(R.color.colorPrimaryLight)
                }
            }
        }
    }

    companion object {
        private const val TAG = "MoviesAdapter"
    }
}