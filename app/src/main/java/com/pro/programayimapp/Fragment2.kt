package com.pro.programayimapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.pro.programayimapp.databinding.Fragment1Binding
import com.pro.programayimapp.databinding.Fragment2Binding

class Fragment2: Fragment(R.layout.fragment_2) {

    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = Fragment2Binding.bind(view)
        binding.apply{
            val prefs = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

            fr2BtnReg.setOnClickListener {
                val editor = prefs.edit()
                editor.putString(Fragment2.KEY_TEXT, fr2Email.text.toString())
                editor.putString(Fragment2.KEY_TEXT_2, fr2Password.text.toString())
                editor.apply()
            }
        }
    }
    companion object {
        private const val KEY_TEXT = "keyText"
        private const val KEY_TEXT_2 = "keyText2"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}