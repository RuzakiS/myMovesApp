package com.example.mymoveapplication.domain.repo

import com.example.mymoveapplication.data.pojo.movie.MovieData
import com.example.mymoveapplication.data.pojo.movie.MovieDetails

interface MovieRepo {
    suspend fun getMovies(page: Int):List<MovieData>
    suspend fun getMovie(id:String):MovieDetails
}
