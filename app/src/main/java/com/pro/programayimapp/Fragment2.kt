package com.pro.programayimapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.pro.programayimapp.databinding.Fragment2Binding

class Fragment2: Fragment(R.layout.fragment_2) {
    private var fr2Binding: Fragment2Binding? = null

    private lateinit var listener: OnClickListener
    private lateinit var txt: AppCompatTextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = Fragment2Binding.bind(view)
        fr2Binding = binding
        binding.fr2Txt.text = arguments?.getString("text")

        binding.fr2Btn.setOnClickListener {
//            val ACTION_ACTIVITY2 = "android.intent.action.SHOW_ACTIVITY"
            val intent = Intent("android.intent.action.SHOW_ACTIVITY")
//            intent.putExtra(Intent.EXTRA_TEXT, binding.fr2Txt.text)
            intent.putExtra("text", binding.fr2Txt.text)
            startActivity(intent)
//            if (intent.resolveActivity(packageManager) != null) {
//                startActivity(intent)
//            } else {
//                Log.d("ImplicitIntents", "Can't handle this intent!")
//            }
        }
    }

    override fun onDestroyView() {
        fr2Binding = null
        super.onDestroyView()
    }


}