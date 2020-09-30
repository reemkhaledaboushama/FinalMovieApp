package com.reem.android.finalmovieapp.data.models.ui

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



@Entity(tableName = "fav_movies_table")

data class FavMovie(
    @PrimaryKey
    @SerializedName("id")
    var id: Long,
    @SerializedName("title")
    var title: String,
    @SerializedName("overview")
    var overview: String,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("backdrop_path")
    var backdropPath: String,
    @SerializedName("vote_average")
    var rating: Float,
    @SerializedName("release_date")
    var releaseDate: String
)

