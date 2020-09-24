package com.reem.android.finalmovieapp.data.models.remote

import com.google.gson.annotations.SerializedName
import com.reem.android.finalmovieapp.data.models.ui.Movie

data class GetMoviesResponse(
    val page:Int,
    val total_results:Int,
    val total_pages:Int,
    val results:List<Movie>,
    val dates: Date
)
data class Date(val maximum:String,val minimum:String)
