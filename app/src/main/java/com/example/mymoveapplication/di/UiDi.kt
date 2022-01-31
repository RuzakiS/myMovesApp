package com.example.mymoveapplication.di

import com.example.mymoveapplication.ui.main.FragMovieDetailsViewM
import com.example.mymoveapplication.ui.main.MovieFragViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiViewModelCreate = module {

    viewModel<MovieFragViewModel> {

        MovieFragViewModel(
            getMoviesUseCase = get(),
        )
    }

    viewModel<FragMovieDetailsViewM> {

        FragMovieDetailsViewM(
            getMovieDetailsUseCase = get()
        )
    }


}