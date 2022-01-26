package com.example.mymoveapplication.ui.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.mymoveapplication.R
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel


//class MainActivity2 : AppCompatActivity() {

//    private val viewSecondVM: MainSecondVM by viewModel<MainSecondVM>()
//    private var viewModelFactory: ViewModelFactory? = null

//
//    private val imgBaseUrl = "https://image.tmdb.org/t/p/original"
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
//
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentSecondPlace, MovieFragSecond()).commit()
//
//
//
////        fun bind(movie: MovieDetails) {
////            constrinL.tvMDtitle.text = movie.originalTitle
////            constrinL.tvMDVote.text = movie.voteAverage.toString()
////            constrinL.tvMDOverview.text = movie.overview
////
////            Glide.with(constrinL.context)
////                .load(imgBaseUrl + movie.posterPath)
////                .into(constrinL.imgMDetails)
////        }
//
//        var movieID = intent.getStringExtra(KEY_TO_SECOND_ACTIVITY)
//
////        viewModelFactory = ViewModelFactory()
////        viewSecondVM = ViewModelProvider(this, viewModelFactory!!).get(MainSecondVM::class.java)
//
//
//        viewSecondVM!!.secondML.observe(this, Observer {
////            bind(it)
//        })
//
//
////        if (movieID != null) {
//        viewSecondVM!!.moveSecondLiveData(movieID!!)
//
//
//    }
//
//    companion object {
//        const val KEY_TO_SECOND_ACTIVITY = "KEY_TO_SECOND_ACTIVITY"
//    }
//}