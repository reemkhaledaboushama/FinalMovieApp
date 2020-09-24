package com.reem.android.finalmovieapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.reem.android.finalmovieapp.data.models.ui.Movie
import com.reem.android.finalmovieapp.data.repository.MoviesRepository

class TopRatedMoviesViewModel: ViewModel() {

    private val moviesRepository = MoviesRepository()

    val topRatedMoviesLiveData : LiveData<List<Movie>> = liveData {
        val data = moviesRepository.getTopRatedMovies()
        emit(data)
    }
}