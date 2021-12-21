package com.example.mymoveapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymoveapplication.data.pojo.movie.MoveData
import com.example.mymoveapplication.R
import kotlinx.android.synthetic.main.move_item.view.*

class MoveAdapter(
    private val moveList: ArrayList<MoveData>
) : RecyclerView.Adapter<MoveAdapter.MoveHolder>() {


    private val imageURL = "https://cdn.pixabay.com/photo/2013/07/21/13/00/rose-165819__340.jpg"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.move_item, parent, false)
        return MoveHolder(view)
    }

    override fun onBindViewHolder(holder: MoveHolder, position: Int) {
        holder.bind(moveList[position])
    }

    override fun getItemCount() = moveList.size

    fun update(list:ArrayList<MoveData>) {
        moveList.clear()
        moveList.addAll(list)
        notifyDataSetChanged()
    }

    inner class MoveHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(move: MoveData) {
            itemView.tvTextYear.text = move.year
            itemView.tvTextName.text = move.title
            Glide.with(itemView.context)
                .load(imageURL)
                .into(itemView.imgLief)

        }
    }
}