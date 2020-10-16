package com.example.recyclerviewkothlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_viewholder.view.*

class ExampleItemAdapter(val exampleItems: List<ExampleItem>, val listener: OnItemClickListener) :
    RecyclerView.Adapter<ExampleItemAdapter.ExampleItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_viewholder,
            parent, false
        )
        return ExampleItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return exampleItems.size;
    }

    override fun onBindViewHolder(holder: ExampleItemViewHolder, position: Int) {

        holder.imageView.setImageResource(exampleItems[position].imageResource)
        holder.text1.setText(exampleItems[position].text1)
        holder.text2.setText(exampleItems[position].text2)
    }

    inner class ExampleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var imageView: ImageView = itemView.image_view;
        val text1: TextView = itemView.text_view_1;
        val text2: TextView = itemView.text_view_2;


        init {
            itemView.setOnClickListener(View.OnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position);
                }

            })
            imageView.setOnClickListener(View.OnClickListener { v ->

                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onIconClick(position)
//                Log.i("srt",position.toString())
                }
            })
        }

        override fun onClick(v: View?) {


        }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun onIconClick(position: Int)
    }
}