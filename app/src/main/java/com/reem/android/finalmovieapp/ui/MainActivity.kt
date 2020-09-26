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

  private val fragmentManager = supportFragmentManager


    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMoviesAdapter: MoviesAdapter
    private lateinit var popularMoviesLayoutMgr: LinearLayoutManager
    private var popularMoviesPage = 1

    /*private lateinit var topRatedMovies: RecyclerView
    private lateinit var topRatedMoviesAdapter: MoviesAdapter
    private lateinit var topRatedMoviesLayoutMgr: LinearLayoutManager

    private var topRatedMoviesPage = 1
*/

    override fun onCreate(savedInstanceState: Bundle?) {
     /* val bottomnav :BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomnav.setOnNavigationItemSelectedListener(navListener)*/

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment??: return


        val navController = host.navController

        setupBottomNavMenu(navController)


       popularMovies = findViewById(R.id.popular_movies)
        popularMoviesLayoutMgr = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        popularMovies.layoutManager = popularMoviesLayoutMgr
        popularMoviesAdapter = MoviesAdapter(mutableListOf()) { movie -> showMovieDetails(movie) }
        popularMovies.adapter = popularMoviesAdapter


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

//_____________________________ popular_movies CANNOT BE NULL _______________





     /*   topRatedMovies = findViewById(R.id.top_rated_movies)
        topRatedMoviesLayoutMgr = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        topRatedMovies.layoutManager = topRatedMoviesLayoutMgr
       // topRatedMoviesAdapter = MoviesAdapter(mutableListOf()){ movie -> showMovieDetails(movie) }
        topRatedMovies.adapter = topRatedMoviesAdapter


       getPopularMovies()
        //getTopRatedMovies()*/
    }


    private fun setupBottomNavMenu(navController: NavController) {

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav?.setupWithNavController(navController)

    }
//private val navListener: BottomNavigationView.onNavigationItemSelectedListener = BottomNavigationView.onNavigationItemSelectedListener{
//    overr
//}

    private fun setCurrentFragment(fragment:  Fragment) = supportFragmentManager.beginTransaction().apply{
        replace(R.id.fragment_container, fragment)
        commit()
    }


    private fun getPopularMovies() {
        MoviesRepository.getPopularMovies(
            popularMoviesPage,
            ::onPopularMoviesFetched,
            ::onError
        )
    }

    private fun onPopularMoviesFetched(movies: List<Movie>) {
        popularMoviesAdapter.appendMovies(movies)
        attachPopularMoviesOnScrollListener()
    }

    private fun onError() {
        Toast.makeText(this, getString(R.string.error_fetch_movies), Toast.LENGTH_SHORT).show()
    }

    private fun attachPopularMoviesOnScrollListener() {
        popularMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = popularMoviesLayoutMgr.itemCount
                val visibleItemCount = popularMoviesLayoutMgr.childCount
                val firstVisibleItem = popularMoviesLayoutMgr.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    popularMovies.removeOnScrollListener(this)
                    popularMoviesPage++
                    getPopularMovies()
                }
            }
        })
    }

   /* private fun getTopRatedMovies() {
        MoviesRepository.getTopRatedMovies(
            topRatedMoviesPage,
            ::onTopRatedMoviesFetched,
            ::onError
        )
    }

    private fun attachTopRatedMoviesOnScrollListener() {
        topRatedMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = topRatedMoviesLayoutMgr.itemCount
                val visibleItemCount = topRatedMoviesLayoutMgr.childCount
                val firstVisibleItem = topRatedMoviesLayoutMgr.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    topRatedMovies.removeOnScrollListener(this)
                    topRatedMoviesPage++
                    getTopRatedMovies()
                }
            }
        })
    }

    private fun onTopRatedMoviesFetched(movies: List<Movie>) {
        topRatedMoviesAdapter.appendMovies(movies)
        attachTopRatedMoviesOnScrollListener()
    }*/

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

    }


