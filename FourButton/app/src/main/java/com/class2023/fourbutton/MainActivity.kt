package com.class2023.fourbutton

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.class2023.fourbutton.R

class MainActivity : AppCompatActivity() {

//    lateinit var btnNate: Button
//    lateinit var btnEmergencyCall: Button
//    lateinit var btnOpenGal: Button
//    lateinit var btnClose: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        btnNate = findViewById(R.id.btnNate)
//        btnEmergencyCall = findViewById(R.id.btnEmergencyCall)
//        btnOpenGal = findViewById(R.id.btnOpenGal)
//        btnClose = findViewById(R.id.btnClose)
//
//        btnNate.setOnClickListener{
//            val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"))
//            startActivity(mIntent)
//        }
//
//        btnOpenGal.setOnClickListener{
//            val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("tel://911"))
//            startActivity(mIntent)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a: Int = 100
        val b: Int = 200
        val c: Int = a + b

        Log.d("Test", "c = $c")

        var currentTime = 6
        when{
            currentTime == 5 -> {
                Log.d("Test", "현재 시간은 5시 입니다")
            }
            currentTime < 5 -> {
                Log.d("Test", "현재 시간은 5시 이전입니다.")
            }
            currentTime > 5 -> {
                Log.d("Test", "현재 시간은 5시를 넘었습니다.")
            }
        }
    }
}