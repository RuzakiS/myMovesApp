package com.example.mymoveapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import com.example.mymoveapplication.domain.usecase.GetMovieDetailsUseCase

open class MainSecondVM(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {
    private val _secondLiveData: MutableLiveData<MovieDetails> = MutableLiveData()
    val secondML: LiveData<MovieDetails>
        get() = _secondLiveData

    fun moveSecondLiveData(id: String) {
        getMovieDetailsUseCase.execute(
            callback = { moveList ->
                _secondLiveData.postValue(moveList)
            }, id = id)
    }

}