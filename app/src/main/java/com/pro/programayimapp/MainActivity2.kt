package com.pro.programayimapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout

// приложение крашится на старте

class MainActivity2 : AppCompatActivity() {
    private lateinit var txtView: TextView
    private lateinit var linLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trafficlight)

        linLayout = findViewById(R.id.layout)
        txtView = findViewById(R.id.txtView)

        val btn1 = findViewById<AppCompatButton>(R.id.btn1)
        val btn2 = findViewById<AppCompatButton>(R.id.btn2)
        val btn3 = findViewById<AppCompatButton>(R.id.btn3)

        btn1.setOnClickListener {
            txtView.text = "RED"
            txtView.setTextColor(Color.RED)
            linLayout.setBackgroundColor(Color.RED)
            btn1.setTextColor(Color.RED)
        }

        btn2.setOnClickListener {
            txtView.text = "YELLOW"
            txtView.setTextColor(Color.YELLOW)
            linLayout.setBackgroundColor(Color.YELLOW)
            btn2.setTextColor(Color.YELLOW)
        }

        btn3.setOnClickListener {
            txtView.text = "GREEN"
            txtView.setTextColor(Color.GREEN)
            linLayout.setBackgroundColor(Color.GREEN)
            btn3.setTextColor(Color.GREEN)
        }
    }
}
