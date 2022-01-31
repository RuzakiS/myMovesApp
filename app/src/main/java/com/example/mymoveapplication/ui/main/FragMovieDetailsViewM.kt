package com.example.mymoveapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import com.example.mymoveapplication.domain.usecase.GetMovieDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class FragMovieDetailsViewM(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {


    private val _secondLiveData: MutableLiveData<MovieDetails> = MutableLiveData()
    val secondML: LiveData<MovieDetails>
        get() = _secondLiveData

    fun moveSecondLiveData(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val movieDetails =  getMovieDetailsUseCase.execute(id)
                _secondLiveData.postValue(movieDetails)
            }catch (e:Exception){
//                _errorExp.postValue(e)
            }
            withContext(Dispatchers.Main) {
                _secondLiveData.value = getMovieDetailsUseCase.execute(id)
            }
        }

    }

}