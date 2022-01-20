package com.example.mymoveapplication.data.net

import com.example.mymoveapplication.data.pojo.movie.MovieData
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServieces {

    @GET("movie/popular")
    fun getMovieList(
        @Query("api_key") apiKey: String
    ): Call<MovieData>

    @GET("movie/{movie_id}")
    fun getCurrentMovie(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String
    ): Call<MovieDetails>

}