package com.example.mymoveapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.mymoveapplication.R
import com.example.mymoveapplication.data.pojo.movie.MovieDetails
import kotlinx.android.synthetic.main.fragment_second_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragSecond : Fragment(R.layout.fragment_second_layout) {

    private val viewModel: MainSecondVM by viewModel<MainSecondVM>()

    private val imgBaseUrl = "https://image.tmdb.org/t/p/original"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_layout, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inputData = arguments?.getString(KEY_TO_SECOND_ACTIVITY)

        viewModel.moveSecondLiveData(inputData!!)
        viewModel.secondML.observe(this, Observer {
            bind(it)
        })

    }

    fun bind(movie: MovieDetails) {
        tvMDtitle.text = movie.originalTitle
        tvMDVote.text = movie.voteAverage.toString()
        tvMDOverview.text = movie.overview

        Glide.with(requireContext())
            .load(imgBaseUrl + movie.posterPath)
            .into(imgMDetails)
    }
    
    companion object {
        fun newInstance() = MovieFragment()
        const val KEY_TO_SECOND_ACTIVITY = "KEY_TO_SECOND_ACTIVITY"
    }
}



//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        fun bind(movie: MovieDetails) {
//            constrinL.tvMDtitle.text = movie.originalTitle
//            constrinL.tvMDVote.text = movie.voteAverage.toString()
//            constrinL.tvMDOverview.text = movie.overview
//
//            Glide.with(constrinL.context)
//                .load(imgBaseUrl + movie.posterPath)
//                .into(constrinL.imgMDetails)
//        }
//
//
//        val movieID = "" // intent.getStringExtra(KEY_TO_SECOND_ACTIVITY)
//
//        viewModel.secondML.observe(this, Observer {
//            bind(it)
//        })
//
//
////        if (movieID != null) {
//        viewModel.moveSecondLiveData(movieID!!)
//
//    }
