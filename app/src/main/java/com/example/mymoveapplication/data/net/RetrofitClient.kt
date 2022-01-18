package com.example.mymoveapplication.data.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private var retrofit: RetrofitServieces? = null

    fun getClient(): RetrofitServieces {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitServieces::class.java)
        }
        return retrofit!!
    }

}