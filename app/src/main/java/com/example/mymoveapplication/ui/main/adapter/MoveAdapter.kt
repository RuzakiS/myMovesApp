package com.example.mymoveapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymoveapplication.R
import com.example.mymoveapplication.data.pojo.movie.MoveData
import kotlinx.android.synthetic.main.move_item.view.*

class MoveAdapter(
    val itemClick: (MoveData) -> Unit
) : RecyclerView.Adapter<MoveAdapter.MoveHolder>() {
    private val moveList = mutableListOf<MoveData>()

    private val imgBaseUrl = "https://image.tmdb.org/t/p/original"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.move_item, parent, false)
        return MoveHolder(view)
    }

    override fun onBindViewHolder(holder: MoveHolder, position: Int) {
        holder.bind(moveList[position])
    }

    override fun getItemCount() = moveList.size

    fun update(list: List<MoveData>) {
        moveList.clear()
        moveList.addAll(list)
        notifyDataSetChanged()
    }

    inner class MoveHolder(item: View) : RecyclerView.ViewHolder(item) {


        fun bind(move: MoveData) {
            itemView.imgLief.setOnClickListener {
                itemClick(move)
            }

            itemView.tvTextYear.text = move.originalLanguage
            itemView.tvTextName.text = move.title
            Glide.with(itemView.context)
                .load(imgBaseUrl + move.posterPath)
                .into(itemView.imgLief)
//            Glide.with(itemView.context)
//                .load(imgBaseUrl + move.posterPath)
//                .into(itemView.imgMDetails)
//            itemView..text = move.voteAverage?.toString()?:"0"
//            itemView..text = move.originalTitle?:""
//            itemView..text = move.overview?:""
        }
    }
}


