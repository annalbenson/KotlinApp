package com.annabenson.kotlinapp

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var messageView : TextView
    lateinit var button : Button

    var strings = ArrayList<String>()
    lateinit var recyclerView : RecyclerView
    lateinit var recyclerViewAdapter : RecyclerViewAdapter

    val mainActivity : MainActivity = this

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


        // recycler view

        recyclerView = findViewById(R.id.recyclerID)
        recyclerViewAdapter = RecyclerViewAdapter(strings,mainActivity)

        recyclerView.adapter = recyclerViewAdapter



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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.menuChoiceA -> {
                Toast.makeText(this, "A", Toast.LENGTH_SHORT).show()

            }
            R.id.menuChoiceB -> {
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show()

            }
            else ->
            {
                Toast.makeText(this, "else", Toast.LENGTH_SHORT).show()
                return super.onOptionsItemSelected(item)
            }
        }
        return true
    }


    // recycler view classes ???




}