package com.reem.android.finalmovieapp.data.models.remote

import com.google.gson.annotations.SerializedName
import com.reem.android.finalmovieapp.data.models.ui.Movie

data class GetMoviesResponse(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val movies: List<Movie>,

    @SerializedName("total_pages")
    val pages: Int
)
