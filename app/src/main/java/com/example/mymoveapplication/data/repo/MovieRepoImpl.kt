package com.example.mymoveapplication.data.repo

import android.util.Log
import com.example.mymoveapplication.data.net.RetrofitClient
import com.example.mymoveapplication.data.pojo.movie.MoveData
import com.example.mymoveapplication.data.pojo.movie.MovieData
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import com.example.mymoveapplication.domain.repo.MovieRepo
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepoImpl : MovieRepo {

    override fun getMovies(
        callback: (List<MoveData>) -> Unit,
        errorCallback: (Throwable) -> Unit,
    ) {


        RetrofitClient.getClient().getMovieList("ebd618f162ffeafbcae3dab64b5aa6a2")
            .enqueue(object : Callback<MovieData> {
                override fun onResponse(
                    call: Call<MovieData>,
                    response: Response<MovieData>
                ) {
                    val movieBody = response.body()
                    val gson = Gson()
                    val jsonString = gson.toJson(movieBody)
                    Log.d("Result", jsonString)
                    if (movieBody != null) {
                        callback(movieBody.results ?: emptyList())
                    } else {
                        errorCallback(Throwable("Body is null"))
                    }
                }

                override fun onFailure(
                    call: Call<MovieData>,
                    t: Throwable
                ) {
                    errorCallback(t)
                }

            })
    }

    override fun getMovie(
        id: String,
        callback: (MovieDetails) -> Unit
    ) {
        RetrofitClient.getClient().getCurrentMovie("ebd618f162ffeafbcae3dab64b5aa6a2",id)
            .enqueue(object : Callback<MovieDetails> {
                override fun onResponse(
                    call: Call<MovieDetails>,
                    response: Response<MovieDetails>
                ) {
                    val movieBody = response.body()
                    val gson = Gson()
                    val jsonString = gson.toJson(movieBody)
                    Log.d("Result", jsonString)
                    if (movieBody != null) {
                        callback(movieBody)
                    } else {
//                        errorCallback(Throwable("Body is null"))
                    }
                }

                override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
//                    errorCallback(t)
                }

            })
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
}
//val listHardCode = mutableListOf<MoveData>()
//val url =
//            "https://api.themoviedb.org/3/movie/popular?api_key=ebd618f162ffeafbcae3dab64b5aa6a2&language=en-US&page=1&region=US"

//        listHardCode.add(MoveData(R.drawable.image_lief, "Hello", "2000"))
//        listHardCode.add(MoveData(R.drawable.ic_launcher_background, "Hello", "2000"))
//        listHardCode.add(MoveData(R.drawable.ic_launcher_foreground, "Hello", "2000"))
//        listHardCode.add(MoveData(R.drawable.image_lief, "Hello", "2000"))