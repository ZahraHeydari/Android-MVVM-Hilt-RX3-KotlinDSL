package com.android.imdb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.imdb.R
import com.android.imdb.ui.movies.MoviesFragment
import com.android.imdb.utils.newFragmentInstance
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped

@AndroidEntryPoint
@ActivityScoped
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