package com.reem.android.finalmovieapp.data.repository

import com.reem.android.finalmovieapp.data.models.remote.GetMoviesResponse


import android.util.Log
import com.reem.android.finalmovieapp.data.models.ui.Movie
import com.reem.android.finalmovieapp.data.network.ApiServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MoviesRepository {

    private val api: ApiServices
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ApiServices::class.java)
    }

    suspend fun getPopularMovies () :List<Movie> = api.getPopularMovies().results
    suspend fun getTopRatedMovies () : List<Movie> = api.getTopRatedMovies().results
    }

