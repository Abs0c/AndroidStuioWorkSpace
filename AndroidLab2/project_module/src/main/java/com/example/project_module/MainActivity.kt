package com.example.project_module

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var btn_go_walk : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_go_walk = findViewById(R.id.go_walk)
        btn_go_walk.setOnClickListener(){
            val intent = Intent(this,WalkActivity::class.java)
            startActivity(intent)
        }
    }
}