package com.class2023.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

//dwKim 19018012 MainActivity
class MainActivity : AppCompatActivity() {

    lateinit var oneBtn: Button;
    lateinit var twoBtn: Button;
    lateinit var threeBtn: Button;
    lateinit var fourBtn: Button;
    lateinit var fiveBtn: Button;
    lateinit var sixBtn: Button;
    lateinit var sevenBtn: Button;
    lateinit var eightBtn: Button;
    lateinit var nineBtn: Button;
    lateinit var zeroBtn: Button;
    lateinit var expBtn: Button;
    lateinit var remBtn: Button;
    lateinit var resetBtn: Button;
    lateinit var divBtn: Button;
    lateinit var mulBtn: Button;
    lateinit var minBtn: Button;
    lateinit var plusBtn: Button;
    lateinit var equalBtn: Button;
    lateinit var zeroZeroBtn: Button;
    lateinit var resTextView: TextView;
    var a: Long = 0;
    var calOperator: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        oneBtn = findViewById(R.id.oneBtn)
        twoBtn = findViewById(R.id.twoBtn)
        threeBtn = findViewById(R.id.threeBtn)
        fourBtn = findViewById(R.id.fourBtn)
        fiveBtn = findViewById(R.id.fiveBtn)
        sixBtn = findViewById(R.id.sixBtn)
        sevenBtn = findViewById(R.id.sevenBtn)
        eightBtn = findViewById(R.id.eightBtn)
        nineBtn = findViewById(R.id.nineBtn)
        zeroBtn = findViewById(R.id.zeroBtn)
        expBtn = findViewById(R.id.expBtn)
        remBtn = findViewById(R.id.remBtn)
        resetBtn = findViewById(R.id.resetBtn)
        divBtn = findViewById(R.id.divBtn)
        mulBtn = findViewById(R.id.mulBtn)
        minBtn = findViewById(R.id.minBtn)
        plusBtn = findViewById(R.id.plusBtn)
        equalBtn = findViewById(R.id.equalBtn)
        zeroZeroBtn = findViewById(R.id.zeroZeroBtn)
        resTextView = findViewById(R.id.resTextView)

        oneBtn.setOnClickListener {
            numAdd(resTextView, oneBtn)
        }
        twoBtn.setOnClickListener {
            numAdd(resTextView, twoBtn)
        }
        threeBtn.setOnClickListener {
            numAdd(resTextView, threeBtn)
        }
        fourBtn.setOnClickListener {
            numAdd(resTextView, fourBtn)
        }
        fiveBtn.setOnClickListener {
            numAdd(resTextView, fiveBtn)
        }
        sixBtn.setOnClickListener {
            numAdd(resTextView, sixBtn)
        }
        sevenBtn.setOnClickListener {
            numAdd(resTextView, sevenBtn)
        }
        eightBtn.setOnClickListener {
            numAdd(resTextView, eightBtn)
        }
        nineBtn.setOnClickListener {
            numAdd(resTextView, nineBtn)
        }
        zeroBtn.setOnClickListener {
            numAdd(resTextView, zeroBtn)
        }

        expBtn.setOnClickListener {
            operAdd(resTextView, expBtn)
        }
        remBtn.setOnClickListener {
            operAdd(resTextView, remBtn)
        }
        divBtn.setOnClickListener {
            operAdd(resTextView, divBtn)
        }
        mulBtn.setOnClickListener {
            operAdd(resTextView, mulBtn)
        }
        minBtn.setOnClickListener {
            operAdd(resTextView, minBtn)
        }
        plusBtn.setOnClickListener {
            operAdd(resTextView, plusBtn)
        }
        zeroZeroBtn.setOnClickListener {
            numAdd(resTextView, zeroZeroBtn)
        }

        resetBtn.setOnClickListener {
            resTextView.text = "0"
        }
        equalBtn.setOnClickListener {
            calculate(resTextView)
        }

    }

    private fun numAdd(t: TextView, b: Button){
        val sb = StringBuilder()
        val a = t.text
        val bText = b.text
        if (a.length > 17){
            Toast.makeText(this, "더 이상 큰 수를 입력할 수 없습니다.", Toast.LENGTH_SHORT).show()
            return
        }
        if (a.toString().toLong() == 0.toString().toLong()){
            t.text = bText
            if (bText.toString().toLong() == 0.toString().toLong()){
                t.text = "0"
            }
        }
        else {
            val c = sb.append(a).append(bText)
            t.text = c
        }
    }

    private fun operAdd(t: TextView, b: Button){
        a = t.text.toString().toLong()
        calOperator = b.text.toString()
        t.text = "0"
    }

    private fun calculate(t: TextView) {
        if (calOperator == ""){
            Toast.makeText(this, "잘못된 계산식입니다.", Toast.LENGTH_SHORT).show()
            return
        }
        var result: Long
        var lastNum: Int = t.text.toString().toInt()
        when (calOperator) {
            "**" -> {
                result = a.toFloat().pow(lastNum.toFloat()).toLong()
            }
            "x" -> {
                result = a * lastNum
            }
            "/" -> {
                if (lastNum == 0){
                    Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show()
                    return
                }
                result = a / lastNum
            }
            "%" -> {
                if (lastNum == 0){
                    Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show()
                    return
                }
                result = a % lastNum
            }
            "+" -> {
                result = a + lastNum
            }
            "-" -> {
                result = a - lastNum
            }
            else -> {
                Toast.makeText(this, "잘못된 계산식입니다.", Toast.LENGTH_SHORT).show()
                return
            }
        }
        t.text = result.toString()
        calOperator = ""
    }
}
