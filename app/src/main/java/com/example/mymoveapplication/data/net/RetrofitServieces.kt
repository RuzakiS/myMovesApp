package com.example.mymoveapplication.data.net

import com.example.mymoveapplication.data.pojo.movie.MovieResponse
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServieces {

    @GET("movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String
    ): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getCurrentMovie(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String
    ): MovieDetails

}