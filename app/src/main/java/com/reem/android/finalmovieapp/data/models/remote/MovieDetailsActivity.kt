package com.reem.android.finalmovieapp.data.models.remote

import android.app.PendingIntent.getActivity
import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.reem.android.finalmovieapp.R
import com.reem.android.finalmovieapp.data.database.AppDatabase
import com.reem.android.finalmovieapp.data.models.ui.FavMovie
import com.reem.android.finalmovieapp.data.models.ui.MovieT
import com.reem.android.finalmovieapp.data.repository.MoviesRepository
import com.reem.android.finalmovieapp.data.repository.MoviesRepository.dataBase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.POST

const val MOVIE_BACKDROP = "extra_movie_backdrop"
const val MOVIE_POSTER = "extra_movie_poster"
const val MOVIE_TITLE = "extra_movie_title"
const val MOVIE_RATING = "extra_movie_rating"
const val MOVIE_RELEASE_DATE = "extra_movie_release_date"
const val MOVIE_OVERVIEW = "extra_movie_overview"

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var backdrop: ImageView
    private lateinit var poster: ImageView
    private lateinit var title: TextView
    private lateinit var rating: RatingBar
    private lateinit var releaseDate: TextView
    private lateinit var overview: TextView
    private var check: Boolean = false
    private lateinit var favbtn: ImageView
    // private lateinit var database: AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        favbtn = findViewById(R.id.favBtn)
        val extraz = intent.extras

        favbtn.setOnClickListener {

            val redtext = "Added to Favorites"

            val greytext = "Removed from Favorites"


            val duration = Toast.LENGTH_SHORT
            val redtoast = Toast.makeText(this,  redtext, duration)
            val greytoast: Toast = Toast.makeText(this,  greytext, duration)



            check = if (!check) {

                redtoast.show()
                favbtn.setBackgroundResource(R.drawable.addfav)

                /* if (extraz != null) {
                     toDB(extraz)
                 }*/
                true


            } else {
                greytoast.show()
                favbtn.setBackgroundResource(R.drawable.favorite)
                false
            }
        }



        backdrop = findViewById(R.id.movie_backdrop)
        poster = findViewById(R.id.movie_poster)
        title = findViewById(R.id.movie_title)
        rating = findViewById(R.id.movie_rating)
        releaseDate = findViewById(R.id.movie_release_date)
        overview = findViewById(R.id.movie_overview)

        val extras = intent.extras

        if (extras != null) {
            populateDetails(extras)
        } else {
            finish()
        }
    }

    private fun populateDetails(extras: Bundle) {
        extras.getString(MOVIE_BACKDROP)?.let { backdropPath ->
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w1280$backdropPath")
                .transform(CenterCrop())
                .into(backdrop)
        }

        extras.getString(MOVIE_POSTER)?.let { posterPath ->
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w342$posterPath")
                .transform(CenterCrop())
                .into(poster)
        }

        title.text = extras.getString(MOVIE_TITLE, "")
        rating.rating = extras.getFloat(MOVIE_RATING, 0f) / 2
        releaseDate.text = extras.getString(MOVIE_RELEASE_DATE, "")
        overview.text = extras.getString(MOVIE_OVERVIEW, "")
    }

    /* fun setFavoriteMovies(extras: Bundle): FavMovie {
         lateinit var favfavmovie: FavMovie
 
         favfavmovie.title = extras.getString(MOVIE_TITLE, "")
         favfavmovie.rating = extras.getFloat(MOVIE_RATING, 0f) / 2
         favfavmovie.releaseDate = extras.getString(MOVIE_RELEASE_DATE, "")
         favfavmovie.overview = extras.getString(MOVIE_OVERVIEW, "")
         favfavmovie.posterPath = extras.getString(MOVIE_POSTER, "")
 
         return favfavmovie
     }
 
     fun toDB(extras: Bundle){
 
         database.getFavMoviesDao().insertMovie( setFavoriteMovies(extras))
 
 
 
     }
 
     fun createDatabase(context: Context) {
        database = AppDatabase.getDatabase(context)
     }*/

    /* extras.getString(MOVIE_POSTER)?.let { posterPath ->
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w342$posterPath")
            .transform(CenterCrop())
            .into(poster)
    }*/

    /* title.text = extras.getString(MOVIE_TITLE, "")
    rating.rating = extras.getFloat(MOVIE_RATING, 0f) / 2
    releaseDate.text = extras.getString(MOVIE_RELEASE_DATE, "")
    overview.text = extras.getString(MOVIE_OVERVIEW, "")
}*/

}