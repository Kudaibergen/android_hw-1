package com.pro.programayimapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity4 : AppCompatActivity(),  OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
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