package com.example.mymoveapplication.di

import com.example.mymoveapplication.domain.usecase.GetMovieDetailsUseCase
import com.example.mymoveapplication.domain.usecase.GetMovieResponseUseCase
import com.example.mymoveapplication.domain.usecase.GetMoviesUseCase
import org.koin.dsl.module


val domainDi = module {

    factory<GetMovieDetailsUseCase> {
        GetMovieDetailsUseCase(
            moviesRepo = get()
        )
    }
    factory<GetMoviesUseCase> {
        GetMoviesUseCase(
            moviesRepo = get()
        )
    }
    factory<GetMovieResponseUseCase> {
        GetMovieResponseUseCase(
            moviesRepo = get()
        )
    }


}
