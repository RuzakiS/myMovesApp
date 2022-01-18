package com.example.mymoveapplication.ui.utlis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymoveapplication.data.repo.MovieRepoImpl
import com.example.mymoveapplication.domain.repo.MovieRepo
import com.example.mymoveapplication.domain.usecase.GetMovieDetailsUseCase
import com.example.mymoveapplication.domain.usecase.GetMoviesUseCase
import com.example.mymoveapplication.ui.main.MainSecondVM
import com.example.mymoveapplication.ui.main.MainViewModel


class ViewModelFactory() : ViewModelProvider.Factory {

    private val movieRepo: MovieRepo = MovieRepoImpl()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(GetMoviesUseCase(movieRepo)) as T
        }else if (modelClass.isAssignableFrom(MainSecondVM::class.java))
            return MainSecondVM(GetMovieDetailsUseCase(movieRepo)) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
