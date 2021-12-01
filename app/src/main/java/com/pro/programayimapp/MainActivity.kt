package com.pro.programayimapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),  OnClickListener {
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

    override fun onClicked(text: String) {
        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("text", text)
        fragment2.arguments = bundle
//        val arg = fragment2.arguments
//            arg?.putString("text", text)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment2)
            .addToBackStack(null) // чтобы возвр-ся к предыдущему
            .commit()

    }

}