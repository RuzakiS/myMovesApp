package com.example.mymoveapplication.ui.main


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymoveapplication.data.pojo.movie.MovieData
import com.example.mymoveapplication.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class MovieFragViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _movesLD: MutableLiveData<List<MovieData>> = MutableLiveData()
    val movesLD: LiveData<List<MovieData>>
        get() = _movesLD

    private val _errorExp: MutableLiveData<Throwable> = MutableLiveData()
    val errorExp: LiveData<Throwable>
        get() =_errorExp


    fun moveList() {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                val movieList = getMoviesUseCase.execute()
                _movesLD.postValue(movieList)
            }catch (e:Exception){
                _errorExp.postValue(e)
            }
            withContext(Dispatchers.Main){
                _movesLD.value = getMoviesUseCase.execute()
            }
        }

    }

}