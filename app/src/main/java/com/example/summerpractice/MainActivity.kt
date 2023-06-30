package com.example.summerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var clickButton: Button? = null
    private lateinit var etname: EditText
    private lateinit var etheight: EditText
    private lateinit var etweight: EditText
    private lateinit var etage: EditText
    private lateinit var etvalue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.button)
        etname = findViewById(R.id.editTextText3)
        etheight = findViewById(R.id.editTextText2)
        etweight = findViewById(R.id.editTextText)
        etage = findViewById(R.id.editTextText4)
        etvalue = findViewById(R.id.textView)

        clickButton?.setOnClickListener {
            val username = etname.text.toString().trim()
            val weight = etweight.text.toString()
            val height = etheight.text.toString()
            val age = etage.text.toString()
            var value = etvalue.text
            if (username.isEmpty() || username.length > 50) {
                etname.error = "Имя введено некорректно"
                return@setOnClickListener
            } else if (weight./*toString().*/isEmpty() || weight.toDouble() > 250.0 || weight.toDouble() < 0.0) {
                etweight.error = "Вес введен некорректно!"
                return@setOnClickListener
            } else if (height.toString().isEmpty() || height.toInt()> 250 || height.toInt()< 0) {
                etheight.error = "Рост введен некорректно!"
                return@setOnClickListener
            } else if (age.toString().isEmpty() || age.toInt() > 150 || age.toInt()< 0) {
                etage.error = "Возраст введен некорректно!"
                return@setOnClickListener
            } else
                Toast.makeText(this, "Валидация завершена", Toast.LENGTH_SHORT).show()
            value =
                (height.toInt() % 10 + weight.toDouble() % 10 + username.length + age.toInt() * 10).toString()
            etvalue.text = "Ответ:  $value"

        }

    }
}
