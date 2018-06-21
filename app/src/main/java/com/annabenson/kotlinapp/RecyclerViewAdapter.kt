package com.annabenson.kotlinapp

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import java.util.ArrayList

class RecyclerViewAdapter(private val argStrings: ArrayList<String>, private val argMainActivity: MainActivity) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private val strings: ArrayList<String>
    private val mainActivity: MainActivity

    init{
        strings = argStrings
        mainActivity = argMainActivity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_row, parent, false)

        //itemView.setOnClickListener(mainActivity)
        //itemView.setOnLongClickListener(mainActivity)

        itemView.setOnClickListener {
            Toast.makeText(it.context, "Clicked" , Toast.LENGTH_SHORT).show()
        }
        itemView.setOnLongClickListener {
            Toast.makeText(it.context, "Long clicked" , Toast.LENGTH_SHORT).show()
            false
        }

        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val s = strings[position]
        holder.name.text = s
        holder.c.text = "cText"
        holder.d.text = "dText"
    }

    override fun getItemCount(): Int {
        return strings.size
    }

}



