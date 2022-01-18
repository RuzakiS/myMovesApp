package com.example.mymoveapplication.data.pojo.movie


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MoveData(


        @SerializedName("adult")
        val adult: Boolean? = null,

        @SerializedName("genre_ids")
        val genreIds: List<Int>? = null,

        @SerializedName("id")
        val id: String? = null,

        @SerializedName("original_language")
        val originalLanguage: String? = null,

        @SerializedName("original_title")
        val originalTitle: String? = null,

        @SerializedName("overview")
        val overview: String? = null,

        @SerializedName("popularity")
        val popularity: Double? = null,

        @SerializedName("poster_path")
        val posterPath: String? = null,

        @SerializedName("release_date")
        val releaseDate : String? = null,

        @SerializedName("title")
        val title: String? = null,

        @SerializedName("video")
        val video: Boolean? = null,

        @SerializedName("vote_average")
        val voteAverage: Double? = null,

        @SerializedName("vote_count")
        val voteCount: Int? = null
    ) : Serializable
