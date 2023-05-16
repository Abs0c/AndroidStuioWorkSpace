package com.class2023.dateandtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import java.sql.Time

class MainActivity : AppCompatActivity() {
    lateinit var dateRadioButton: RadioButton
    lateinit var timeRadioButton: RadioButton
    lateinit var datePicker: DatePicker
    lateinit var timePicker: TimePicker
    lateinit var chronometer: Chronometer
    lateinit var reserveFinishButton: Button
    lateinit var reserveTimeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateRadioButton = findViewById(R.id.dateRadioButton)
        timeRadioButton = findViewById(R.id.timeRadioButton)
        datePicker = findViewById(R.id.datePicker)
        timePicker = findViewById(R.id.timePicker)
        chronometer = findViewById(R.id.chronometer)
        reserveFinishButton = findViewById(R.id.reserveFinishBtn)
        reserveTimeTextView = findViewById(R.id.reserveTimeTextView)

        datePicker.visibility = View.INVISIBLE
        timePicker.visibility = View.INVISIBLE

        dateRadioButton.setOnClickListener{
            datePicker.visibility = View.VISIBLE
            timePicker.visibility = View.INVISIBLE
        }

        timeRadioButton.setOnClickListener{
            datePicker.visibility = View.INVISIBLE
            timePicker.visibility = View.VISIBLE
        }


    }
}