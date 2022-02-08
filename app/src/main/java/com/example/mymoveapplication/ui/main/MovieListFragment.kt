package com.example.mymoveapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymoveapplication.R
import com.example.mymoveapplication.data.pojo.movie.MovieData
import com.example.mymoveapplication.ui.main.adapter.MovieAdapter
import kotlinx.android.synthetic.main.fragment_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : Fragment(R.layout.fragment_layout) {

    private val adapter = MovieAdapter {
        toMainActivity2(it)
    }
    private val viewModel: MovieListViewModel by viewModel<MovieListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvFragView.layoutManager = LinearLayoutManager(requireContext())
        var layoutManager = LinearLayoutManager(requireContext())
        rvFragView.adapter = adapter

        viewModel.movesLD.observe(this, Observer {
            adapter.update(it)
        })
        viewModel.moveList()

        viewModel.errorExp.observe(this, Observer {
            Toast.makeText(requireContext(), "Error Found, or Some Wrong", Toast.LENGTH_SHORT)
                .show()
        })

        rvFragView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if (!recyclerView.canScrollVertically(1)) {

                    viewModel.moveList()
                    Toast.makeText(requireContext(), "Last", Toast.LENGTH_LONG).show();

                }
        }
        })
    }


    fun toMainActivity2(moveData: MovieData) {

        val bundle = Bundle()
        bundle.putString(KEY_TO_SECOND_ACTIVITY, moveData.id)
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentPlace, MovieDetailsFragment().apply {
                arguments = bundle
            })?.commit()
    }


    companion object {
        fun newInstance() = MovieListFragment()
        const val KEY_TO_SECOND_ACTIVITY = "KEY_TO_SECOND_ACTIVITY"
    }

}
//       viewModel = ViewModelProvider(this).get(MovieFragViewModel::class.java)


//        val intent = Intent(requireContext(), MainActivity2::class.java).apply {
//            putExtra(KEY_TO_SECOND_ACTIVITY, moveData.id)
//        }
//        startActivity(intent)