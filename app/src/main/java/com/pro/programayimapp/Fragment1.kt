package com.pro.programayimapp

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
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
import com.pro.programayimapp.databinding.Fragment1Binding

class Fragment1: Fragment(R.layout.fragment_1)  {
    private lateinit var listener: OnButtonClicked
    private var _binding: Fragment1Binding? = null
    private val binding = _binding!!

    private lateinit var editEmail: AppCompatTextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = Fragment1Binding.bind(view)
        binding.apply{}
        val btn1 = view.findViewById<AppCompatButton>(R.id.btn_reg)
        val editEmail = view.findViewById<AppCompatTextView>(R.id.email)
        val editPassword = view.findViewById<AppCompatTextView>(R.id.password)

        val prefs = requireContext().getSharedPreferences("MyPrefs", MODE_PRIVATE)

        btn1.setOnClickListener {
            val editor = prefs.edit()
            editor.putString(KEY_TEXT, editEmail.text.toString())
            editor.putString(KEY_TEXT_2, editPassword.text.toString())
            editor.apply()

        }
    }

    companion object {
        private const val KEY_TEXT = "keyText"
        private const val KEY_TEXT_2 = "keyText2"
    }
}