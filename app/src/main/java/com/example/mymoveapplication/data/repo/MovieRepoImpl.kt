package com.example.mymoveapplication.data.repo

import com.example.mymoveapplication.data.net.RetrofitServieces
import com.example.mymoveapplication.data.pojo.movie.MovieData
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import com.example.mymoveapplication.domain.repo.MovieRepo

class MovieRepoImpl(
    private val api: RetrofitServieces
) : MovieRepo {

    override suspend fun getMovies(): List<MovieData> {
        val movieResponse = api.getMovieList("ebd618f162ffeafbcae3dab64b5aa6a2")
        return movieResponse.results ?: emptyList()
    }

    override suspend fun getMovie(id: String): MovieDetails {
        val movieDetails = api.getCurrentMovie(id, "ebd618f162ffeafbcae3dab64b5aa6a2")
        return movieDetails
    }
}
//
//    override fun getMovieDetails(
//        id: String,
//        callback: (MovieDetails) -> Unit,
//        errorCallback: (Throwable) -> Unit,
//    ) {
//
//
//    }

//val listHardCode = mutableListOf<MoveData>()
//val url =
//            "https://api.themoviedb.org/3/movie/popular?api_key=ebd618f162ffeafbcae3dab64b5aa6a2&language=en-US&page=1&region=US"

//        listHardCode.add(MoveData(R.drawable.image_lief, "Hello", "2000"))
//        listHardCode.add(MoveData(R.drawable.ic_launcher_background, "Hello", "2000"))
//        listHardCode.add(MoveData(R.drawable.ic_launcher_foreground, "Hello", "2000"))
//        listHardCode.add(MoveData(R.drawable.image_lief, "Hello", "2000"))