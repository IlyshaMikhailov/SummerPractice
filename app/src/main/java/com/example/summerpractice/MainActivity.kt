package com.example.summerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var clickButton: Button? = null
    private var etname: EditText? = null
    private var etheight: EditText? = null
    private var etweight: EditText? = null
    private var etage: EditText? = null
    private var etvalue: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.button)
        etname = findViewById(R.id.nametext)
        etheight = findViewById(R.id.heighttext)
        etweight = findViewById(R.id.weighttext)
        etage = findViewById(R.id.agetext)
        etvalue = findViewById(R.id.textView)

        clickButton?.setOnClickListener {
            val username= etname?.text.toString().trim()
            val weight = etweight?.text.toString()
            val height = etheight?.text.toString()
            val age = etage?.text.toString()
            var isСorrect = true
            if (username.isEmpty() || username.length > 50) {
                etname?.error = getString(R.string.nameexception)
                isСorrect = false
            }
            if (weight.isEmpty() || weight.toDouble() > 250.0 || weight.toDouble() < 0.0) {
                etweight?.error = getString(R.string.weightException)
                isСorrect = false
            }
            if (height.isEmpty() || height.toInt()> 250 || height.toInt()< 0) {
                etheight?.error = getString(R.string.heightException)
                isСorrect = false
            }
            if (age.isEmpty() || age.toInt() > 150 || age.toInt()< 0) {
                etage?.error = getString(R.string.ageException)
                isСorrect = false
            }
            if(isСorrect) {
                Toast.makeText(this, "Валидация завершена", Toast.LENGTH_SHORT).show()
                val value =
                    (height.toInt() % 10 + weight.toDouble() % 10 + username.length + age.toInt() * 10).toString()
                etvalue?.text = "Ответ:  $value"
            }
        }

    }
}
