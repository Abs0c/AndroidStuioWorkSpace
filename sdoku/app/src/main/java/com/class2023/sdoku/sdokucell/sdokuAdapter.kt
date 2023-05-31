//package com.class2023.sdoku.sdokucell
//
//import android.R
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//
//
//class sdokuAdapter(val sdokuArr: Array<Array<sdokuCell>>) : BaseAdapter(){
//    override fun getCount(): Int {
//        return sdokuArr.size * sdokuArr[0].size
//    }
//
//    override fun getItem(p0: Int): Any {
//        return sdokuArr[p0/9][p0%9]
//    }
//
//    override fun getItemId(p0: Int): Long {
//        return p0.toLong()
//    }
//
//    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
//        val context = p2?.context
//        val item  = sdokuArr[p0/9][p0%9]
//        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val returnView = inflater.inflate(R.layout.sdoku, viewGroup, false)
//
//        if (p1 == null){
//
//        }
//    }
//}