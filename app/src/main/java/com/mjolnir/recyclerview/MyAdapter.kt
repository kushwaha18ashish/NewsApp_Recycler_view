package com.mjolnir.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyAdapter(var newsArrayList:ArrayList<News>,var context:Activity):
RecyclerView.Adapter<MyAdapter.myViewHolder>(){


    private lateinit var myListner:onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickOnListener(listener:onItemClickListener){
        myListner=listener
    }



    class myViewHolder(itemView: View,listener:onItemClickListener):RecyclerView.ViewHolder(itemView) {
        val hTitle=itemView.findViewById<TextView>(R.id.tvHeading)
        val hImage=itemView.findViewById<ImageView>(R.id.ivHeadingImage)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.myViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)
        return myViewHolder(itemView,myListner)
    }

    override fun onBindViewHolder(holder: MyAdapter.myViewHolder, position: Int) {
         var currentItem=newsArrayList[position]
        holder.hTitle.text=currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)


    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }




}