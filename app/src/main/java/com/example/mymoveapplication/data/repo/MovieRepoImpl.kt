package com.example.mymoveapplication.data.repo

import com.example.mymoveapplication.R
import com.example.mymoveapplication.data.pojo.movie.MoveData
import com.example.mymoveapplication.domain.repo.MovieRepo

class MovieRepoImpl: MovieRepo {

    override fun getMovies(): List<MoveData> {
        val listHardCode = mutableListOf<MoveData>()

        listHardCode.add(MoveData(R.drawable.image_lief, "Hello", "2000"))
        listHardCode.add(MoveData(R.drawable.ic_launcher_background, "Hello", "2000"))
        listHardCode.add(MoveData(R.drawable.ic_launcher_foreground, "Hello", "2000"))
        listHardCode.add(MoveData(R.drawable.image_lief, "Hello", "2000"))

        return listHardCode
    }

}