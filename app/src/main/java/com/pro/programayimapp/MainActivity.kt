package com.pro.programayimapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnButtonClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragments()
    }

    override fun onButtonClicked(text: String) {
//        val txt.text = text
    }

    private fun initFragments() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Fragment1())
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container2, Fragment2())
            .commit()
    }

}