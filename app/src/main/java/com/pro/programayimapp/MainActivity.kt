package com.pro.programayimapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pro.programayimapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendBtn.setOnClickListener {
            val email = binding.email.text.toString()
            val subject = binding.editSubject.text.toString()
            val letter = binding.editLetter.text.toString()

            val emails = email.split(",".toRegex()).toTypedArray()

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, emails)
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, letter)
            }

            if (intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }else{
                Toast.makeText(this@MainActivity, "Приложение не установлено", Toast.LENGTH_SHORT).show()
            }
        }
    }
}