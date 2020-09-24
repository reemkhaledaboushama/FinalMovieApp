package com.reem.android.finalmovieapp.data.network
import com.reem.android.finalmovieapp.data.models.remote.GetMoviesResponse
import retrofit2.http.GET


private const val apiKey ="d78d306988042530d99e166c3cb00017"
interface ApiServices {

    @GET("popular?api_key=$apiKey")
    suspend fun getPopularMovies(): GetMoviesResponse

    @GET("top_rated?api_key=$apiKey")
    suspend fun getTopRatedMovies(): GetMoviesResponse





}