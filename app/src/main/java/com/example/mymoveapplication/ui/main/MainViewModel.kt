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

    private val _errorExp: MutableLiveData<Throwable> = MutableLiveData()
    val errorExp: LiveData<Throwable>
        get() =_errorExp


    fun moveList() {
        getMoviesUseCase.execute(
            callback = {  moveList ->
                _movesLD.postValue(moveList)
            },
            errorCallBack = { errorThr ->
                _errorExp.postValue(errorThr)
            })
    }

}