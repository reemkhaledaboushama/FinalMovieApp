package com.reem.android.finalmovieapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.reem.android.finalmovieapp.data.models.remote.MovieDetailsActivity
import com.reem.android.finalmovieapp.data.models.ui.FavMovie
import com.reem.android.finalmovieapp.data.models.ui.Movie
@Dao
interface FavMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: FavMovie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<FavMovie>)

    @Query("SELECT * FROM fav_movies_table")
    fun getAllMovies(): MutableList<FavMovie>

}