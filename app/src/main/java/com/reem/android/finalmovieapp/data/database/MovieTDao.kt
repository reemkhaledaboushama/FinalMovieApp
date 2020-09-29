package com.reem.android.finalmovieapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.reem.android.finalmovieapp.data.models.ui.MovieT

@Dao
interface MovieTDao {
    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    //fun insertMovie(movie: MovieT)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllT(movies: List<MovieT>)

    @Query("SELECT * FROM moviesT_table")
    fun getAllMoviesT(): List<MovieT>


}