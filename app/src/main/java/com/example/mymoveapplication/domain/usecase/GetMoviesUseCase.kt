package com.example.mymoveapplication.domain.usecase

import com.example.mymoveapplication.data.pojo.movie.MoveData
import com.example.mymoveapplication.domain.repo.MovieRepo

class GetMoviesUseCase(
    private val moviesRepo: MovieRepo
) {

    fun execute(callback: (List<MoveData>) -> Unit, errorCallBack: (Throwable) -> Unit) {
        moviesRepo.getMovies(callback,errorCallBack)
    }


}