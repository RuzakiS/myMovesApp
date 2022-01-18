package com.example.mymoveapplication.domain.repo

import com.example.mymoveapplication.data.pojo.movie.MoveData
import com.example.mymoveapplication.data.pojo.movie.MovieDetails

interface MovieRepo {
    fun getMovies(callback: (List<MoveData>) -> Unit,errorCallback: (Throwable) -> Unit)
    fun getMovie(id: String, callback: (MovieDetails) -> Unit)
}