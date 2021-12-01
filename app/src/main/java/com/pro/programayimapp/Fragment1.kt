package com.pro.programayimapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1: Fragment(R.layout.fragment_1)  {
    private lateinit var listener: OnClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.fr_recycler)
        val layoutManager = LinearLayoutManager(activity)
        val adapter = SimpleAdapter {
            Toast.makeText(activity, "ITEM -$it", Toast.LENGTH_SHORT).show()
            listener.onClicked("ITEM -$it")
        }

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))


        val list = mutableListOf<String>()
        for (i in 0..20) {
            list.add("ITEM -$i")

        }
        adapter.setData(list)

    }
}