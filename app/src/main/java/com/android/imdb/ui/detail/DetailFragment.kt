package com.android.imdb.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import coil.load
import com.android.imdb.data.model.Movie
import com.android.imdb.data.model.MovieDetail
import com.android.imdb.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped


@AndroidEntryPoint
@FragmentScoped
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding
    private val detailViewModel: DetailViewModel by viewModels()
    private var movie: Movie? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.apply {
            if (containsKey(Movie::class.java.name)) {
                movie = getParcelable<Movie>(Movie::class.java.name)
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater)
        val view = binding?.root


        with(detailViewModel) {

            getDetail(movie?.imdbID ?: "0")

            movieDetailData.observe(this@DetailFragment, Observer {
                loadData(it)
            })
        }


        return view
    }


    private fun loadData(movieDetail: MovieDetail) {

        binding?.run {

            detailPosterImageView.load(movieDetail.poster)
            detailProductionTextView.text = movieDetail.production
            detailWriterTextView.text = movieDetail.writer
            detailTitleTextView.text = movieDetail.title
            detailAwardsTextView.text = movieDetail.awards
            detailBoxOfficeTextView.text = movieDetail.boxOffice
            detailPlotTextView.text = movieDetail.plot
            detailDirectorTextView.text = movieDetail.director
            detailDurationTextView.text = movieDetail.runtime
            detailTypeTextView.text = movieDetail.type
            detailYearTextView.text = movieDetail.year
            detailStarsTextView.text = movieDetail.actors
            detailReleasedTextView.text = movieDetail.released
            detailLanguageTextView.text = movieDetail.language
            detailRatingsImdbTextView.text = movieDetail.imdbRating
            detailGenreTextView.text = movieDetail.genre
            detailRatingsRottenTomatoesTextView.text =  movieDetail.ratings?.find { it.source == "Rotten Tomatoes" }?.value ?: "N/A"
            detailRatingsMetacriticTextView.text = movieDetail.ratings?.find { it.source == "Metacritic" }?.value ?: "N/A"
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        val FRAGMENT_NAME = DetailFragment::class.java.simpleName
        private const val TAG = "DetailFragment"
    }
}