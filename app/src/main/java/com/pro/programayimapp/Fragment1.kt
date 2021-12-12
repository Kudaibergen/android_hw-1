package com.pro.programayimapp

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class Fragment1: Fragment(R.layout.fragment_1)  {

    private lateinit var btnLogin:AppCompatButton
    private lateinit var email:AppCompatEditText
    private lateinit var password:AppCompatEditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email = view.findViewById(R.id.email)
        password = view.findViewById(R.id.password)
        btnLogin = view.findViewById(R.id.btnLogin)

        email.addTextChangedListener(loginTextWatcher)
        password.addTextChangedListener(loginTextWatcher)

        btnLogin.setOnClickListener {
            if (email.text.toString() == "altynai@gmail.com" && password.text.toString() == "altynai") {

                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, Fragment2())
                transaction.disallowAddToBackStack()
                transaction.commit()

            } else if (!isValidEmail(email.text.toString())) {
                Toast.makeText(activity, "Неккоректная почта", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Почта или пароль не совпадают", Toast.LENGTH_SHORT).show()
            }
        }
    }

// Проверка email
    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

// Если поле пустое кнопка неактивна
    private val loginTextWatcher = object :TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString().trim()
            btnLogin.isEnabled = emailText.isNotEmpty() && passwordText.isNotEmpty()
        }
        override fun afterTextChanged(p0: Editable?) {}
    }

// Change orientation
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("MyTag", "onSaveInstanceState")

        outState.putString(EMAIL_KEY, email.text.toString())
        outState.putString(PASSWORD_KEY, password.text.toString())
    }


    companion object {
        const val EMAIL_KEY = "COUNT_KEY"
        const val PASSWORD_KEY = "COUNT_KEY"
    }
}