package com.reem.android.finalmovieapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.reem.android.finalmovieapp.data.models.ui.Movie
import com.reem.android.finalmovieapp.data.repository.MoviesRepository

class PopularMoviesViewModel: ViewModel() {
    private val moviesRepository = MoviesRepository()

    val popularMoviesLiveData : LiveData<List<Movie>> = liveData {
        val data = moviesRepository.getPopularMovies()
        emit(data)
    }

}