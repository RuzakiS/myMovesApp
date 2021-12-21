package com.example.mymoveapplication.domain.repo

import com.example.mymoveapplication.data.pojo.movie.MoveData

interface MovieRepo {
    fun getMovies(): List<MoveData>
}