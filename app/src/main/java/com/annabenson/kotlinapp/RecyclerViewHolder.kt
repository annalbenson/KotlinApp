package com.annabenson.kotlinapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView


class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var name: TextView
    var symbol: TextView
    var price: TextView
    var change: TextView

    init {
        // do

        name = view.findViewById(R.id.nameID)
        symbol = view.findViewById(R.id.symbolID)
        price = view.findViewById(R.id.priceID)
        change = view.findViewById(R.id.changeID)
    }

}
