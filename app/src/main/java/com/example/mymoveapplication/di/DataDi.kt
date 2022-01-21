package com.example.mymoveapplication.di

import com.example.mymoveapplication.data.net.RetrofitClient
import com.example.mymoveapplication.data.net.RetrofitServieces
import com.example.mymoveapplication.data.repo.MovieRepoImpl
import com.example.mymoveapplication.domain.repo.MovieRepo
import org.koin.dsl.module

val dataDi = module {

    single<MovieRepo>{
        MovieRepoImpl(get())
    }

//    single<MovieRepoImpl>{
//        MovieRepoImpl(
//            get()
//        )
//    }

}