package com.example.mymoveapplication.data.pojo.movie


import java.io.Serializable

data class MoveData(
        val image: Int,
        val title: String,
        val year: String
    ) : Serializable
