package com.class2023.mypictureviewprevnext

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import androidx.core.app.ActivityCompat
import com.class2023.mypictureviewprevnext.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    var curNum: Int = 0
    var imageFiles : Array<File>? = null
    lateinit var imageFname: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "이미지 뷰어"
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)

        imageFiles = File(Environment.getExternalStorageDirectory().absolutePath + "/Pictures").listFiles()
        imageFname = imageFiles!![0].toString()
        binding.myPictureView1.imagePath=imageFname

        binding.btnPrev.setOnClickListener{
            if (curNum <= 0){
                curNum = imageFiles!!.size - 1
            }
            else{
                curNum--
            }
            imageFname = imageFiles!![curNum].toString()
            binding.myPictureView1.imagePath = imageFname
            binding.myPictureView1.invalidate()
        }

        binding.btnNext.setOnClickListener{
            if (curNum <= imageFiles!!.size - 1){
                curNum = 0
            }
            else{
                curNum++
            }
            imageFname = imageFiles!![curNum].toString()
            binding.myPictureView1.imagePath = imageFname
            binding.myPictureView1.invalidate()
        }
    }
}