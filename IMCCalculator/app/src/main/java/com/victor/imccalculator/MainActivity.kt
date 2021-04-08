package com.victor.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import com.victor.imccalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn_calculate = binding.btnCalculate
        val message = binding.message

        btn_calculate.setOnClickListener {
            val weight = binding.weightEditText.text.toString()
            val height = binding.heightEditText.text.toString()

            if(weight.isEmpty()) {
                message.text = "Tell Your Weight"
            } else if(height.isEmpty()) {
                message.text = "Tell Your Heigth"
            } else {
                calculateIMC()
            }
        }
    }

    private fun calculateIMC() {
        val weigth = Integer.parseInt(binding.weightEditText.text.toString())
        val heigth = binding.heightEditText.text.toString().toDouble()
        val imc = weigth / (Math.pow(heigth, 2.0))
        val resultType = binding.message

        val message = when {
            imc <= 18.5 -> "Low Weigth"
            imc <= 24.9 -> "Normal Weigth"
            imc <= 29.9 -> "Overweight"
            imc <= 34.9 -> "(Grade 1) Obesity"
            imc <= 39.9 -> "(Grade 2) Obesity"
            else -> "(Grade 3) Morbid Obesity"
        }

        resultType.text = "IMC: " + String.format("%.2f", imc) + "\n $message"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.reset -> {
                binding.heightEditText.setText("")
                binding.weightEditText.setText("")
                binding.message.text = ""
            }
        }

        return super.onOptionsItemSelected(item)
    }
}