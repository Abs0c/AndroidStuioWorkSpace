package com.class2023.piano

import android.os.Build
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var white1: Button
    lateinit var white2: Button
    lateinit var white3: Button
    lateinit var white4: Button
    lateinit var white5: Button
    lateinit var white6: Button
    lateinit var white7: Button
    lateinit var black1: Button
    lateinit var black2: Button
    lateinit var black3: Button
    lateinit var black4: Button
    lateinit var black5: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        white1 = findViewById(R.id.white1)
        white2 = findViewById(R.id.white2)
        white3 = findViewById(R.id.white3)
        white4 = findViewById(R.id.white4)
        white5 = findViewById(R.id.white5)
        white6 = findViewById(R.id.white6)
        white7 = findViewById(R.id.white7)
        black1 = findViewById(R.id.black1)
        black2 = findViewById(R.id.black2)
        black3 = findViewById(R.id.black3)
        black4 = findViewById(R.id.black4)
        black5 = findViewById(R.id.black5)

        white1.setOnClickListener(){
            Toast.makeText(this, "도", Toast.LENGTH_SHORT).show()
        }
        white2.setOnClickListener(){
            Toast.makeText(this, "레", Toast.LENGTH_SHORT).show()
        }
        white3.setOnClickListener(){
            Toast.makeText(this, "미", Toast.LENGTH_SHORT).show()
        }
        white4.setOnClickListener(){
            Toast.makeText(this, "파", Toast.LENGTH_SHORT).show()
        }
        white5.setOnClickListener(){
            Toast.makeText(this, "솔", Toast.LENGTH_SHORT).show()
        }
        white6.setOnClickListener(){
            Toast.makeText(this, "라", Toast.LENGTH_SHORT).show()
        }
        white7.setOnClickListener(){
            Toast.makeText(this, "시", Toast.LENGTH_SHORT).show()
        }
        registerForContextMenu(black1)
        registerForContextMenu(black2)
        registerForContextMenu(black3)
        registerForContextMenu(black4)
        registerForContextMenu(black5)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        val inflater = menuInflater
        if (v == black1){
            inflater.inflate(R.menu.context_menu_1, menu)
        }
        if (v == black2){
            inflater.inflate(R.menu.context_menu_2, menu)
        }
        if (v == black3){
            inflater.inflate(R.menu.context_menu_3, menu)
        }
        if (v == black4){
            inflater.inflate(R.menu.context_menu_4, menu)
        }
        if (v == black5){
            inflater.inflate(R.menu.context_menu_5, menu)
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }
}