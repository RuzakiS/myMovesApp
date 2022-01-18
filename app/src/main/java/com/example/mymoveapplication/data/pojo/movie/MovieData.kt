package com.example.mymoveapplication.data.pojo.movie

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MovieData(

    @SerializedName("page")
    var page: Int? = null,

    @SerializedName("results")
    var results: List<MoveData>? = null,

    @SerializedName("total_pages")
    var totalPages: Int? = null,

    @SerializedName("total_results")
    var totalResults: Int? = null
) : Serializable
