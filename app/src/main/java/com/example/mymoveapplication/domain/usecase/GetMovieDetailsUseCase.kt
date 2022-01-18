package com.example.mymoveapplication.domain.usecase

import com.example.mymoveapplication.data.pojo.movie.MoveData
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import com.example.mymoveapplication.domain.repo.MovieRepo

class GetMovieDetailsUseCase(
    private val moviesRepo: MovieRepo
) {
    fun execute(
        id: String,
        callback: (MovieDetails) -> Unit
    ) {
        moviesRepo.getMovie(id, callback)
    }
}