package com.pro.programayimapp

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pro.programayimapp.databinding.Fragment1Binding

class Fragment1: Fragment(R.layout.fragment_1)  {
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    private lateinit var listener: OnButtonClicked

//    private lateinit var editEmail: AppCompatTextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = Fragment1Binding.bind(view)
        binding.apply{
            val prefs = requireContext().getSharedPreferences("MyPrefs", MODE_PRIVATE)

            btnReg.setOnClickListener {
                val regEmail = prefs.getString("email", "")
                val regPassword = prefs.getString("password", "")

                if (binding.email.equals(regEmail) && binding.password.equals(regPassword)){
                    parentFragmentManager.beginTransaction().apply {
                        replace(R.id.fragment_container, Fragment2())
                            .addToBackStack(null)
                            .commit()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}