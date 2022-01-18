package com.example.mymoveapplication.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymoveapplication.R
import com.example.mymoveapplication.data.pojo.movie.MoveData
import com.example.mymoveapplication.ui.main.adapter.MoveAdapter
import com.example.mymoveapplication.ui.utlis.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = MoveAdapter  {
      toMainActivity2(it)
    }

//        this::toMainActivity2)

    private var viewModel: MainViewModel? = null
    private var viewModelFactory: ViewModelFactory? = null

//    lateinit var a :String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        this::a.isLateinit

        viewModelFactory = ViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory!!).get(MainViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel!!.movesLD.observe(this, Observer {
            adapter.update(it)
        })
        viewModel!!.moveList()

        viewModel!!.errorExp.observe(this, Observer {
            Toast.makeText(this, "Error Found, or Some Wrong", Toast.LENGTH_SHORT).show()
        })

    }

    fun toMainActivity2(moveData: MoveData){
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(KEY_TO_SECOND_ACTIVITY,moveData.id)
        }
        startActivity(intent)
    }

//    val intent = Intent(this, EditInfoActivity::class.java)
//    val userDetails = UserDetails()
//    intent.putExtra(KEY_TO_EDIT_INFO, userDetails)

    companion object {
        const val KEY_TO_SECOND_ACTIVITY = "KEY_TO_SECOND_ACTIVITY"
    }

}
