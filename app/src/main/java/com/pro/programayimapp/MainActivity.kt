package com.pro.programayimapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.pro.programayimapp.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var lastNumeric: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clear.setOnClickListener {
            binding.txtView1.text = ""
            binding.txtView2.text = ""
        }

        binding.zero.setOnClickListener{
            binding.txtView1.append("0")
        }

        binding.one.setOnClickListener{
            binding.txtView1.append("1")
        }

        binding.two.setOnClickListener{
            binding.txtView1.append("2")
        }

        binding.three.setOnClickListener{
            binding.txtView1.append("3")
        }

        binding.four.setOnClickListener{
            binding.txtView1.append("4")
        }

        binding.five.setOnClickListener{
            binding.txtView1.append("5")
        }

        binding.six.setOnClickListener{
            binding.txtView1.append("6")
        }

        binding.seven.setOnClickListener{
            binding.txtView1.append("7")
        }

        binding.eight.setOnClickListener{
            binding.txtView1.append("8")
        }

        binding.nine.setOnClickListener{
            binding.txtView1.append("9")
        }

        binding.addition.setOnClickListener{
            binding.txtView1.append(" + ")
        }

        binding.subtract.setOnClickListener{
            binding.txtView1.append(" - ")
        }

        binding.divide.setOnClickListener{
            binding.txtView1.append(" / ")
        }

        binding.multiply.setOnClickListener{
            binding.txtView1.append(" * ")
        }

        binding.dot.setOnClickListener{
            binding.txtView1.append(".")
        }

        binding.leftBrace.setOnClickListener{
            binding.txtView1.append(" ( ")
        }

        binding.rightBrace.setOnClickListener{
            binding.txtView1.append(" ) ")
        }

        binding.back.setOnClickListener{
            binding.txtView1.text = binding.txtView1.text.dropLast(1)
        }

        binding.equals.setOnClickListener{
            try {
                val expression = ExpressionBuilder(binding.txtView1.text.toString()).build()
                val result = expression.evaluate()
                val longresult = result.toLong()

                if (result == longresult.toDouble()) {
                    binding.txtView2.text = longresult.toString()
                } else {
                    binding.txtView2.text = result.toString()
                }
            }catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                Log.d("EXCEPTION", "Message: ${e.message}")
            }
        }
    }
}