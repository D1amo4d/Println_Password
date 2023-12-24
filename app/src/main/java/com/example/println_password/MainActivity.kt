package com.example.println_password

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.println_password.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val passwordDigits = mutableListOf<Int?>(null, null, null, null, null, null)
    private val correctPassword = listOf(1, 2, 3, 4, 5, 6) // Здесь нужно указать правильный пароль

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tv1.setOnClickListener { setNumber(1, binding.tochka1) }
        binding.tv2.setOnClickListener { setNumber(2, binding.tochka2) }
        binding.tv3.setOnClickListener { setNumber(3, binding.tochka3) }
        binding.tv4.setOnClickListener { setNumber(4, binding.tochka4) }
        binding.tv5.setOnClickListener { setNumber(5, binding.tochka5) }
        binding.tv6.setOnClickListener { setNumber(6, binding.tochka6) }

        binding.btnSubmit.setOnClickListener {
            checkPassword()
        }

        binding.btnClear.setOnClickListener {
            clearPassword()
        }
    }

    private fun setNumber(number: Int, textView: TextView) {
        for (i in passwordDigits.indices) {
            if (passwordDigits[i] == null) {
                passwordDigits[i] = number
                break
            }
        }
        val index = number - 1
        val textColor = if (passwordDigits[index] != null) Color.YELLOW else Color.GRAY
        textView.setTextColor(textColor)
    }

    private fun checkPassword() {
        if (passwordDigits == correctPassword) {
            // Пароль верный
            Toast.makeText(this, "Пароль верный", Toast.LENGTH_SHORT).show()
            // Здесь можно выполнить действия, соответствующие правильному паролю
        } else {
            // Пароль неверный
            Toast.makeText(this, "Пароль неверный", Toast.LENGTH_SHORT).show()
            // Здесь можно выполнить действия, соответствующие неправильному паролю
        }
    }

    private fun clearPassword() {
        passwordDigits.fill(null) // Очистка массива пароля
        binding.tochka1.setTextColor(Color.GRAY)
        binding.tochka2.setTextColor(Color.GRAY)
        binding.tochka3.setTextColor(Color.GRAY)
        binding.tochka4.setTextColor(Color.GRAY)
        binding.tochka5.setTextColor(Color.GRAY)
        binding.tochka6.setTextColor(Color.GRAY)
    }
}
