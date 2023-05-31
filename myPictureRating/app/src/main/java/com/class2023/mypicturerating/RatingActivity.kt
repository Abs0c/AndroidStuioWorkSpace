package com.class2023.mypicturerating

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.class2023.mypicturerating.databinding.ActivityRatingBinding

class RatingActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityRatingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = intent
        var getResArr = intent.getIntegerArrayListExtra("resArr")

        binding.ratingBar0.rating = getResArr!![0].toFloat()
        binding.ratingBar1.rating = getResArr!![1].toFloat()
        binding.ratingBar2.rating = getResArr!![2].toFloat()
        binding.ratingBar3.rating = getResArr!![3].toFloat()
        binding.ratingBar4.rating = getResArr!![4].toFloat()
        binding.ratingBar5.rating = getResArr!![5].toFloat()
    }
}