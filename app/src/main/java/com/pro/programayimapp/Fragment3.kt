package com.pro.programayimapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class Fragment3: Fragment(R.layout.fragment_3) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<Toolbar>(R.id.fr3_toolbar)
        toolbar.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction() // hw-18: здесь не правильно. Получается мы добавляем фрагмент в стек
                .replace(R.id.fragment_container, Fragment2()) // нам же нужно вернуться назад. Подсказка: onBackPressed()
                .disallowAddToBackStack()
                .commit()
        }
    }

}
