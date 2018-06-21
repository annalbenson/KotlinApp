package com.annabenson.kotlinapp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView


class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var name: TextView
    var c: TextView
    var d: TextView

    init {

        name = view.findViewById(R.id.nameID)
        c = view.findViewById(R.id.cID)
        d = view.findViewById(R.id.dID)
    }

}
