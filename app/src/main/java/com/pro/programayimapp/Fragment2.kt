package com.pro.programayimapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2: Fragment(R.layout.fragment_2) {
    private lateinit var listener: OnClickListener
    private lateinit var txt: AppCompatTextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txt = view.findViewById<AppCompatTextView>(R.id.fr2_txt)
        txt.text = arguments?.getString("text")
    }


}