package com.example.androidlab

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //이름 문자열 출력 TextView 생성
        val name = TextView(this).apply{
            typeface = Typeface.DEFAULT_BOLD
            text = "Lake Louise"
        }
        val image = ImageView(this).apply{
            //iterator().setImageDrawable
        }
        setContentView(R.layout.activity_main)
    }
}