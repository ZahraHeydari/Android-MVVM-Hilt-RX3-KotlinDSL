package com.android.imdb.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.android.imdb.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped


@AndroidEntryPoint
@FragmentScoped
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding

    private val detailViewModel : DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater)
        val view = binding?.root


        with(detailViewModel){

            loadDetail("13")

            movie.observe(this@DetailFragment, Observer {
                Log.i(TAG, "onCreateView: $it")
            })
        }


        return view
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