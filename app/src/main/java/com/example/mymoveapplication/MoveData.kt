package com.example.mymoveapplication


import java.io.Serializable

data class MoveData(
        val image: Int,
        val title: String,
        val year: String
    ) : Serializable
