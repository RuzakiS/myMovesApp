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

open class MovieListViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _movesLD: MutableLiveData<List<MovieData>> = MutableLiveData()
    val movesLD: MutableLiveData<List<MovieData>>
        get() = _movesLD

    private val _errorExp: MutableLiveData<Throwable> = MutableLiveData()
    val errorExp: LiveData<Throwable>
        get() = _errorExp
    private var page = 0
    private var isLoading: Boolean = false
    private var isLastPageLoad: Boolean = false


    fun moveList() {

        viewModelScope.launch(Dispatchers.IO) {
            if (!isLoading && !isLastPageLoad) {
                var gettingMovies: List<MovieData> = listOf()
                isLoading = true
                page++
                try {
                    gettingMovies = getMoviesUseCase.execute(page)
                    isLoading = false
                } catch (e: Exception) {
                    _errorExp.postValue(e)
                }

                withContext(Dispatchers.Main) {
                    val list: MutableList<MovieData> = mutableListOf()
                    list.addAll(_movesLD.value ?: emptyList())
                    list.addAll(gettingMovies)
                    _movesLD.value = list
                }

            }
        }
    }

}


//            try {
//                val movieList = getMoviesUseCase.execute(page)
//                _movesLD.postValue(movieList)
//            } catch (e: Exception) {
//                _errorExp.postValue(e)
//            }
//            withContext(Dispatchers.Main) {
//                _movesLD.value = getMoviesUseCase.execute(page)
//            }