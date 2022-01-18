package com.example.mymoveapplication.ui.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mymoveapplication.R
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import com.example.mymoveapplication.domain.usecase.GetMovieDetailsUseCase
import com.example.mymoveapplication.ui.utlis.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.view.*


class MainActivity2 : AppCompatActivity() {

    private var viewSecondVM: MainSecondVM? = null
    private var viewModelFactory: ViewModelFactory? = null


    private val imgBaseUrl = "https://image.tmdb.org/t/p/original"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        fun bind(movie: MovieDetails) {
            constrinL.tvMDtitle.text = movie.originalTitle
            constrinL.tvMDVote.text = movie.voteAverage.toString()
            constrinL.tvMDOverview.text = movie.overview

            Glide.with(constrinL.context)
                .load(imgBaseUrl + movie.posterPath)
                .into(constrinL.imgMDetails)
        }

        var movieID = intent.getStringExtra(KEY_TO_SECOND_ACTIVITY)

        viewModelFactory = ViewModelFactory()
        viewSecondVM = ViewModelProvider(this, viewModelFactory!!).get(MainSecondVM::class.java)


        viewSecondVM!!.secondML.observe(this, Observer {
            bind(it)
        })



//        if (movieID != null) {
            viewSecondVM!!.moveSecondLiveData(movieID!!)






    }

    companion object {
        const val KEY_TO_SECOND_ACTIVITY = "KEY_TO_SECOND_ACTIVITY"
    }
}