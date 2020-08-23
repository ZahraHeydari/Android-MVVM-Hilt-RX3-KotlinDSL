package com.android.imdb.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.imdb.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater)
        val view = binding?.root

        return view
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        val FRAGMENT_NAME = DetailFragment::class.java.simpleName
    }
}