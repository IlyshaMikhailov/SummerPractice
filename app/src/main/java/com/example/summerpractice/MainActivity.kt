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
            val weight = etweight.text.toString().trim().toDouble()
            val height = etheight.text.toString().trim().toInt()
            val age = etage.text.toString().trim().toInt()
            var value = etvalue.text
            if (username.isEmpty() || username.length > 50) {
                etname.error = "Имя введено некорректно"
                return@setOnClickListener
            } else if (weight.toString().isEmpty() || weight > 250.0 || weight < 0.0) {
                etweight.error = "Вес введен некорректно!"
                return@setOnClickListener
            } else if (height.toString().isEmpty() || height> 250 || height< 0) {
                etheight.error = "Рост введен некорректно!"
                return@setOnClickListener
            } else if (age.toString().isEmpty() || age > 150 || age< 0) {
                etage.error = "Возраст введен некорректно!"
                return@setOnClickListener
            } else
                Toast.makeText(this, "Валидация завершена", Toast.LENGTH_SHORT).show()
            value =
                (height % 10 + weight % 10 + username.length + age * 10).toString()
            etvalue.text = "Ответ:  $value"

        }

    }
}
