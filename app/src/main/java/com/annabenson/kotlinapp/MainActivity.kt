package com.annabenson.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //var button : Button // how to declare w/o initializing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageView : TextView = findViewById(R.id.messageID)
        val startMsg : String = "Hello Kotlin!"
        messageView.setText( startMsg )

        val button : Button = findViewById(R.id.buttonID)
        button.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        }

        

    }
}
