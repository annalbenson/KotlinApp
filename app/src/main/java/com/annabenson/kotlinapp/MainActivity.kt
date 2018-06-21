package com.annabenson.kotlinapp

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {
// how to implement onClickListener

    private val tag = "MainActivity"

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
        recyclerView.layoutManager = LinearLayoutManager(mainActivity)

    }

    fun buttonDialog(){
        val builder : AlertDialog.Builder = AlertDialog.Builder(this)

        val editText = EditText(this)
        editText.inputType = InputType.TYPE_CLASS_TEXT
        editText.gravity = Gravity.CENTER_HORIZONTAL

        builder.setView(editText)

        builder.setPositiveButton("OK", DialogInterface.OnClickListener{ dialog, whichButton ->
            Log.d(tag,"buttonDialog : positive button clicked")
            val input : String = editText.text.toString()
            Log.d(tag, "adding input" + input)
            //messageView.text = input
            addNewListItem(input)

        })

        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, whichButton ->
            Log.d(tag,"buttonDialog : negative button clicked")
        })


        builder.setMessage("Enter String:")
        builder.setTitle("ADD STRING")

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

    fun addNewListItem( input : String){
        strings.add(input)
        strings.sort()
        recyclerViewAdapter.notifyDataSetChanged()
    }

    /*
    override fun onClick(view: View) {
        val pos = recyclerView.getChildLayoutPosition(view)
        val chore = chores.get(pos)

        Toast.makeText(view.context, "Clicked on " + chore.getName(), Toast.LENGTH_SHORT).show()
    }

    override fun onLongClick(view: View): Boolean {
        val pos = recyclerView.getChildLayoutPosition(view)
        val chore = chores.get(pos)
        Toast.makeText(view.context, "Long clicked on " + chore.getName(), Toast.LENGTH_SHORT).show()
        return false
    }

*/
    // recycler view classes ???




}