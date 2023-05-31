package com.class2023.gridmovieposter

import android.R
import android.content.Context
import android.graphics.BitmapFactory
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import java.io.File


class PosterAdapter(var context: Context): BaseAdapter() {
    var Posters: Array<File> = File("./storage/emulated/0/Pictures").listFiles()
    override fun getCount(): Int {
        return Posters.size
    }
    override fun getItem(p0: Int): Any {
        return Posters[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong();
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var imageView = ImageView(context)
        imageView.layoutParams = ViewGroup.LayoutParams(200, 300)
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        imageView.setPadding(5, 5, 5, 5)


        var imageBitmap = BitmapFactory.decodeFile(Posters[p0].toString())
        imageView.setImageBitmap(imageBitmap)
    }
}

