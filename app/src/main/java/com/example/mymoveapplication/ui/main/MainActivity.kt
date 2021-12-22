package com.example.mymoveapplication.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mymoveapplication.ui.main.adapter.MoveAdapter
import com.example.mymoveapplication.data.pojo.movie.MoveData
import com.example.mymoveapplication.R
import com.example.mymoveapplication.ui.utlis.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val adapter = MoveAdapter(ArrayList())


    private var viewModel: MainViewModel? = null
    private var viewModelFactory: ViewModelFactory? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelFactory = ViewModelFactory()
        viewModel = ViewModelProvider(this,viewModelFactory!!).get(MainViewModel::class.java)


        recyclerView.adapter = adapter

//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel!!.movesLD.observe(this, Observer {
            adapter.update(it as ArrayList<MoveData>)
        })
        viewModel!!.moveList()


    }
}