package com.reem.android.finalmovieapp.data.repository

import android.content.Context
import com.reem.android.finalmovieapp.data.models.remote.GetMoviesResponse


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reem.android.finalmovieapp.data.database.AppDatabase
import com.reem.android.finalmovieapp.data.models.remote.GetMoviesResponseT
import com.reem.android.finalmovieapp.data.models.ui.Movie
import com.reem.android.finalmovieapp.data.models.ui.MovieT
import com.reem.android.finalmovieapp.data.network.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesRepository {

    private val api: ApiServices
    private val tag: String = MoviesRepository::class.java.simpleName

    private val popularMoviesList: MutableList<Movie> = mutableListOf()
    private val topRatedMoviesList: MutableList<MovieT> = mutableListOf()
    private lateinit var dataBase: AppDatabase




    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ApiServices::class.java)
    }


    fun getPopularMovies(page: Int = 1): LiveData<MutableList<Movie>> {

        val moviesListLiveData: MutableLiveData<MutableList<Movie>> = MutableLiveData()


        if (popularMoviesList.size > 0) {
            moviesListLiveData.postValue(popularMoviesList)
            return moviesListLiveData
        }
        else if (getLocalMovies().isNotEmpty()) {
            popularMoviesList.addAll(getLocalMovies())
            moviesListLiveData.postValue(popularMoviesList)
        }


        api.getPopularMovies(page = page)
            .enqueue(object : Callback<GetMoviesResponse> {
                override fun onResponse(
                    call: Call<GetMoviesResponse>,
                    response: Response<GetMoviesResponse>
                ) {
                    if (response.isSuccessful) {
                        val remoteMoviesList: List<Movie> = response.body()?.movies ?: listOf()
                        popularMoviesList.addAll(remoteMoviesList)
                        dataBase.getMoviesDao().insertAll(popularMoviesList)
                        moviesListLiveData.postValue(popularMoviesList)
                    }
                }

                override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
                    Log.e(tag, t.message.toString())
                }
            })
        return moviesListLiveData
    }


    fun getTopRatedMovies(page: Int=1):LiveData<MutableList<MovieT>> {
        val moviesListLiveData: MutableLiveData<MutableList<MovieT>> = MutableLiveData()

        if (topRatedMoviesList.size > 0) {
            moviesListLiveData.postValue(topRatedMoviesList)
            return moviesListLiveData
        }else if (getLocalMoviesT().isNotEmpty()) {
            topRatedMoviesList.addAll(getLocalMoviesT())
            moviesListLiveData.postValue(topRatedMoviesList)
        }
        api.getTopRatedMovies(page = page)
            .enqueue(object : Callback<GetMoviesResponseT> {
                override fun onResponse(
                    call: Call<GetMoviesResponseT>,
                    response: Response<GetMoviesResponseT>
                ) {
                    if (response.isSuccessful) {
                        val remoteMoviesList: List<MovieT> =
                            response.body()?.movies ?: listOf()
                        topRatedMoviesList.addAll(remoteMoviesList)
                        dataBase.getMoviesTDao().insertAllT(topRatedMoviesList)
                        moviesListLiveData.postValue(topRatedMoviesList)

                    }
                }

                override fun onFailure(call: Call<GetMoviesResponseT>, t: Throwable) {
                }
            })
        return moviesListLiveData

    }

    private fun getLocalMovies(): List<Movie> {
        return dataBase.getMoviesDao().getAllMovies()
    }

    private fun getLocalMoviesT(): List<MovieT> {
        return dataBase.getMoviesTDao().getAllMoviesT()
    }

    fun createDatabase(context: Context) {
        dataBase = AppDatabase.getDatabase(context)
    }

    }

