package com.example.mymoveapplication.domain.usecase

import com.example.mymoveapplication.data.pojo.movie.MoveData
import com.example.mymoveapplication.domain.repo.MovieRepo

class GetMoviesUseCase(
    private val moviesRepo: MovieRepo
) {

    fun execute(): List<MoveData> {
        val moviesList = moviesRepo.getMovies()
        return moviesList
    }

}