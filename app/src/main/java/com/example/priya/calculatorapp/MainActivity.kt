package com.example.priya.calculatorapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view: View) {
        if(isNewOp)
        {
            edShowNumber.setText("")
        }
        isNewOp=false
        val buSelect = view as Button
        var buClickValue: String = edShowNumber.text.toString()
        when (buSelect.id) {
            b0.id -> {
                buClickValue += "0"
            }
            b1.id -> {
                buClickValue += "1"
            }
            b2.id -> {
                buClickValue += "2"
            }
            b3.id -> {
                buClickValue += "3"
            }
            b4.id -> {
                buClickValue += "4"
            }
            b5.id -> {
                buClickValue += "5"
            }
            b6.id -> {
                buClickValue += "6"
            }
            b7.id -> {
                buClickValue += "7"
            }
            b8.id -> {
                buClickValue += "8"
            }
            b9.id -> {
                buClickValue += "9"
            }
            bDot.id -> {
                buClickValue += "."
            }
            bPlusMinus.id -> {
                buClickValue = "-" + buClickValue
            }
        }
        edShowNumber.setText(buClickValue)
    }
    var op="*"
    var oldNumber=""
    var isNewOp=true

    fun buOperations(view: View) {
        val buSelect = view as Button
        when (buSelect.id) {
            bMul.id -> {
                op="*"

            }
            bDiv.id -> {
                op="/"

            }
            bSub.id -> {
                op="-"

            }
            bSum.id -> {
                op="+"

            }

        }
        oldNumber=edShowNumber.text.toString()
        isNewOp=true
    }
    fun buEqualEvent(view: View)
    {
        val newNumber=edShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op)
        {
            "*"->
            {
                finalNumber=oldNumber.toDouble() * newNumber.toDouble()

            }
            "/"->
            {
                finalNumber=oldNumber.toDouble() / newNumber.toDouble()

            }
            "+"->
            {
                finalNumber=oldNumber.toDouble() + newNumber.toDouble()

            }
            "-"->
            {
                finalNumber=oldNumber.toDouble() - newNumber.toDouble()

            }
        }
        edShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }

    fun bPercent(view: View)
    {
        val number:Double=edShowNumber.text.toString().toDouble()/100
        edShowNumber.setText(number.toString())
        isNewOp=true
    }

    fun bClean(view: View)
    {
        edShowNumber.setText("")
        isNewOp=true

    }
}