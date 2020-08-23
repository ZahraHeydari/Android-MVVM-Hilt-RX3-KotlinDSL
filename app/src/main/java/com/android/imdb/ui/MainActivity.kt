package com.android.imdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.imdb.R
import com.android.imdb.ui.detail.DetailFragment
import com.android.imdb.ui.movies.MoviesFragment
import com.android.imdb.utils.newFragmentInstance

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) navigateToMovies()
    }

    private fun navigateToMovies() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_container,
                newFragmentInstance<MoviesFragment>(),
                MoviesFragment.FRAGMENT_NAME
            )
            .commit()
    }

    companion object {
        val TAG = MainActivity::class.java.name
    }
}