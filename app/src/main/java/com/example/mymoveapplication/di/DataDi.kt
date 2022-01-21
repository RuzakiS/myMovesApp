package com.example.mymoveapplication.di

import com.example.mymoveapplication.data.repo.MovieRepoImpl
import com.example.mymoveapplication.domain.repo.MovieRepo
import org.koin.dsl.module

val dataDi = module {

    single<MovieRepo>{
        MovieRepoImpl()
    }
}