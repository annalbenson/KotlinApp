package com.annabenson.kotlinapp

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.InputType
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {


    lateinit var messageView : TextView
    lateinit var button : Button

    // can't really declare b/c it would be null until set later

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        messageView = findViewById(R.id.messageID)
        val startMsg : String = "Hello Kotlin!"
        messageView.text = startMsg

        button = findViewById(R.id.buttonID)
        button.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            buttonDialog()
        }


    }

    fun buttonDialog(){
        val builder : AlertDialog.Builder = AlertDialog.Builder(this)

        val editText = EditText(this)
        editText.inputType = InputType.TYPE_CLASS_TEXT
        editText.gravity = Gravity.CENTER_HORIZONTAL

        builder.setView(editText)

        builder.setPositiveButton("OK", DialogInterface.OnClickListener{ dialog, whichButton ->
            print("buttonDialog : positive clicked")
            val input : String = editText.text.toString()
            messageView.text = input

        })

        /*
        builder.setPositiveButton("OK", DialogInterface.OnClickListener{
            print("buttonDialog : positive clicked")
            val input : String = editText.text.toString()
            messageView.text = input
        })
        */

        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, whichButton ->
            print("buttonDialog : negative clicked")
        })

            /*
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener{
            print("buttonDialog : negative clicked")
        })
        */

        builder.setMessage("ABC")
        builder.setTitle("DEF")

        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

}
