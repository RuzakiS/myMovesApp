package com.example.mymoveapplication.di

import com.example.mymoveapplication.ui.main.MainSecondVM
import com.example.mymoveapplication.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiViewModelCreate = module {

    viewModel<MainViewModel> {

        MainViewModel(
            getMoviesUseCase = get(),
        )
    }

    viewModel<MainSecondVM> {

        MainSecondVM(
            getMovieDetailsUseCase = get()
        )
    }


}