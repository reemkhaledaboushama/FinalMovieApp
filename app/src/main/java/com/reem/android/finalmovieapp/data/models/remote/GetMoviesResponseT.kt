package com.reem.android.finalmovieapp.data.models.remote

import com.google.gson.annotations.SerializedName
import com.reem.android.finalmovieapp.data.models.ui.MovieT

data class GetMoviesResponseT (
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<MovieT>,
    @SerializedName("total_pages")
    val pages: Int)