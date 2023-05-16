package com.class2023.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnCommunity: Button
    lateinit var btnMap: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCommunity = findViewById(R.id.btnCommunity)
        btnMap = findViewById(R.id.btnMap)

        btnMap.setOnClickListener(){
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        btnCommunity.setOnClickListener(){
            val intent = Intent(this, CommunityActivity::class.java)
            startActivity(intent)
        }
    }
}