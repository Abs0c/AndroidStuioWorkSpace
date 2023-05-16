package com.class2023.test

import android.app.ProgressDialog.show
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.MapView

class MapActivity : AppCompatActivity() {
    lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        mapView = findViewById(R.id.mapView)
        //mapView.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.parkMenuItem -> Toast.makeText(this, "공원 표기", Toast.LENGTH_SHORT).show()
            R.id.eatMenuItem -> Toast.makeText(this, "식당 표기", Toast.LENGTH_SHORT).show()
            R.id.hospitalMenuItem -> Toast.makeText(this, "병원 표기", Toast.LENGTH_SHORT).show()
            R.id.cafeMenuItem -> Toast.makeText(this, "카페 표기", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}