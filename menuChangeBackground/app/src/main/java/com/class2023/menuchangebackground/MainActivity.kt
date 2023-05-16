package com.class2023.menuchangebackground

import android.graphics.Color
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

lateinit var toastMsgText: TextView
lateinit var layout: LinearLayout
lateinit var redTextView: TextView
lateinit var greenTextView: TextView
lateinit var blueTextView: TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toastMsgText = findViewById(R.id.toastMsgText)
        layout = findViewById(R.id.constraintLayoutMain)
        redTextView = findViewById(R.id.rTextView)
        greenTextView = findViewById(R.id.gTextView)
        blueTextView = findViewById(R.id.bTextView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.toastMsg -> Toast.makeText(this, toastMsgText.text, Toast.LENGTH_SHORT).show()
            R.id.rgcBackgroundChange -> layout.setBackgroundColor(rgb(redTextView.text.toString().toInt(), greenTextView.text.toString().toInt(), blueTextView.text.toString().toInt()))
        }
        return super.onOptionsItemSelected(item)
    }
}