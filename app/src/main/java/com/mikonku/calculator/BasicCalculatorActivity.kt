package com.mikonku.calculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.fathzer.soft.javaluator.DoubleEvaluator

class BasicCalculatorActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_basic_calculator)

    }

    override fun onClick(v: View?) {
        var tv = v as TextView
        var resultTV = findViewById<TextView>(R.id.resultTV)
        var oldText = resultTV.text.toString()

        when(tv.text.toString()){
            "Del" -> {
                if(oldText.length > 0){
                    var newText = oldText.substring(0, oldText.length - 1)
                    resultTV.setText(newText)
                }
            }
            "" -> {resultTV.setText(null)}
            "=" -> {
                if (oldText != ""){

                    if(!isOperator(oldText[oldText.length - 1])){
                        var evaluator = DoubleEvaluator()
                        var expression = resultTV.text.replace(Regex("×"), "*")
                        var result = evaluator.evaluate(expression)
                        resultTV.setText(result.toString())
                    }

                }

            }
            else -> {
                var toAppendString = tv.text.toString()
                if(isOperator(toAppendString[0]) && isOperator(oldText[oldText.length - 1])){
                    oldText = oldText.substring(0, oldText.length - 1)
                }
                var newText = oldText + toAppendString
                resultTV.setText(newText)
            }
        }
    }

    public fun isOperator(c: Char): Boolean {
        when(c){
            'x', '*', '×', '/', '+', '-' -> { return true}
            else -> return false
        }
    }
}