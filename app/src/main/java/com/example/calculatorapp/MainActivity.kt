package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.toSpanned

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNumber = ""
    var operation = "+"

    lateinit var edit:EditText
    lateinit var bu1 :Button
    lateinit var bu2:Button
    lateinit var bu3 :Button
    lateinit var bu4 :Button
    lateinit var bu5 :Button
    lateinit var bu6 :Button
    lateinit var bu7:Button
    lateinit var bu8 :Button
    lateinit var bu9 :Button
    lateinit var bu0:Button
    lateinit var dot :Button
    lateinit var plusMin:Button
    lateinit var buDivide :Button
    lateinit var buPlus :Button
    lateinit var buMin : Button
    lateinit var buMul :Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      edit = findViewById(R.id.TextV)
        bu1 = findViewById(R.id.bu1)
        bu2 = findViewById(R.id.bu2)
        bu3= findViewById(R.id.bu3)
        bu4 = findViewById(R.id.bu4)
        bu5 = findViewById(R.id.bu5)
        bu6 = findViewById(R.id.bu6)
        bu7= findViewById(R.id.bu7)
        bu8 = findViewById(R.id.bu8)
        bu9 = findViewById(R.id.bu9)
        bu0 = findViewById(R.id.bu0)
        dot = findViewById(R.id.buDot)
        plusMin = findViewById(R.id.buPlusMin)
        buPlus = findViewById(R.id.buPlus)
        buMin = findViewById(R.id.buMinus)
        buDivide = findViewById(R.id.buDivide)
        buMul = findViewById(R.id.buMultiply)



    }

    fun numberEvent(view: View) {
      if (isNewOp)
         edit.setText("")
       isNewOp =false
       var buClick = edit.text.toString()
        var buSelect :Button = view as Button
        when (buSelect.id) {
            bu1.id->{buClick += "1"}
            bu2.id->{buClick += "2"}
            bu3.id->{buClick += "3"}
            bu4.id->{buClick += "4"}
            bu5.id->{buClick += "5"}
            bu6.id->{buClick += "6"}
            bu7.id->{buClick += "7"}
            bu8.id->{buClick += "8"}
            bu9.id->{buClick += "9"}
            bu0.id->{buClick += "0"}
            dot.id->{buClick += "."}
            plusMin.id->{buClick = "-$buClick"}


       }
     edit.setText(buClick)

    }

    fun operationEvent(view: View) {
        isNewOp = true
        oldNumber = edit.text.toString()
        var buSelect :Button = view as Button
        when (buSelect.id) {
            buMul.id->{operation= "*"}
            buDivide.id->{operation= "/"}
            buPlus.id->{operation= "+"}
            buMin.id->{operation= "-"}
        }

    }

    fun equalEvent(view: View) {
        var newNumber = edit.text.toString()
        var result = 0.0
        when(operation){
            "*"->{result=oldNumber.toDouble()*newNumber.toDouble()}
            "/"->{result=oldNumber.toDouble()/newNumber.toDouble()}
            "+"->{result=oldNumber.toDouble()+newNumber.toDouble()}
            "-"->{result=oldNumber.toDouble()-newNumber.toDouble()}
        }
        edit.setText(result.toString())

    }

    fun deleteEvent(view: View) {
        edit.setText("0")
        isNewOp= true
    }

    fun percentEvent(view: View) {
        var number = edit.text.toString().toDouble()/100
        edit.setText(number.toString())
        isNewOp = true

    }
}