package com.example.mymoveapplication.ui.main


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymoveapplication.data.pojo.movie.MoveData
import com.example.mymoveapplication.domain.usecase.GetMoviesUseCase

open class MainViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _movesLD: MutableLiveData<List<MoveData>> = MutableLiveData()
    val movesLD: LiveData<List<MoveData>>
        get() = _movesLD


    fun moveList() {
        val listHardCode = getMoviesUseCase.execute()
        _movesLD.postValue(listHardCode)
    }

}