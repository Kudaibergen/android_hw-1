package com.pro.programayimapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Fragment1())
            .commit()
    }

}