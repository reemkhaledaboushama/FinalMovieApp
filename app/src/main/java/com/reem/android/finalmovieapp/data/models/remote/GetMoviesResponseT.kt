package com.reem.android.finalmovieapp.data.models.remote

import com.reem.android.finalmovieapp.data.models.ui.MovieT

data class GetMoviesResponseT (val page: Int, val movies: List<MovieT>)