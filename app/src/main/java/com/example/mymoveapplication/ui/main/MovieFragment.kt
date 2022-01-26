package com.example.mymoveapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymoveapplication.R
import com.example.mymoveapplication.data.pojo.movie.MoveData
import com.example.mymoveapplication.ui.main.adapter.MoveAdapter
import kotlinx.android.synthetic.main.fragment_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment(R.layout.fragment_layout) {

    private val adapter = MoveAdapter {
        toMainActivity2(it)
    }
    private val viewModel: MainViewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvFragView.layoutManager = LinearLayoutManager(requireContext())
        rvFragView.adapter = adapter

        viewModel.movesLD.observe(this, Observer {
            adapter.update(it)
        })
        viewModel.moveList()

        viewModel.errorExp.observe(this, Observer {
            Toast.makeText(requireContext(), "Error Found, or Some Wrong", Toast.LENGTH_SHORT)
                .show()
        })


    }

    fun toMainActivity2(moveData: MoveData) {

        val bundle = Bundle()
        bundle.putString(KEY_TO_SECOND_ACTIVITY, moveData.id)
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentPlace, MovieFragSecond().apply {
                arguments = bundle
            })?.commit()
    }


    companion object {
        fun newInstance() = MovieFragment()
        const val KEY_TO_SECOND_ACTIVITY = "KEY_TO_SECOND_ACTIVITY"
    }

}
//       viewModel = ViewModelProvider(this).get(MovieFragViewModel::class.java)


//        val intent = Intent(requireContext(), MainActivity2::class.java).apply {
//            putExtra(KEY_TO_SECOND_ACTIVITY, moveData.id)
//        }
//        startActivity(intent)