package com.reem.android.finalmovieapp.ui

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment

import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.reem.android.finalmovieapp.R
import com.reem.android.finalmovieapp.R.id.popular_movies
import com.reem.android.finalmovieapp.data.models.remote.*
import com.reem.android.finalmovieapp.data.models.ui.Movie
import com.reem.android.finalmovieapp.data.repository.MoviesRepository
import com.reem.android.finalmovieapp.ui.movie.FavoritesFragment
import com.reem.android.finalmovieapp.ui.movie.PopularFragment
import com.reem.android.finalmovieapp.ui.movie.TopRatedFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popular_fragment.*


class MainActivity : AppCompatActivity() {

   private fun showMovieDetails(movie: Movie) {
       val intent = Intent(this, MovieDetailsActivity::class.java)
       intent.putExtra(MOVIE_BACKDROP, movie.backdropPath)
       intent.putExtra(MOVIE_POSTER, movie.posterPath)
       intent.putExtra(MOVIE_TITLE, movie.title)
       intent.putExtra(MOVIE_RATING, movie.rating)
       intent.putExtra(MOVIE_RELEASE_DATE, movie.releaseDate)
       intent.putExtra(MOVIE_OVERVIEW, movie.overview)
       startActivity(intent)
   }


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val favoritesfragment = FavoritesFragment()
        val popularfragment = PopularFragment()
        val topratedfragment = TopRatedFragment()

        setCurrentFragment(topratedfragment)


        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.top_rated -> setCurrentFragment(topratedfragment)
                R.id.popular -> setCurrentFragment(popularfragment)
                R.id.favorite -> setCurrentFragment(favoritesfragment)

            }
            true
        }




    }

    private fun setCurrentFragment(fragment:  Fragment) = supportFragmentManager.beginTransaction().apply{
        replace(R.id.fragment_container, fragment)
        commit()
    }

    }


