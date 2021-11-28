package com.pro.programayimapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity4 : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        initFragment()

        val recycler = findViewById<RecyclerView>(R.id.fr_recycler)
        val layoutManager = LinearLayoutManager(this)
        val adapter = SimpleAdapter {
            Toast.makeText(this, "ITEM -$it", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("text", "ITEM -$it")
            startActivity(intent)
        }

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 0..20) {
            list.add("ITEM -$i")

        }
        adapter.setData(list)
    }

    override fun onClicked(text: String) {
        val fragment2 = supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, Fragment2())
            .commit()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Fragment1())
            .commit()
    }

}