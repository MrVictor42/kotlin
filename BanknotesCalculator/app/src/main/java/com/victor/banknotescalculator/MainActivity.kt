 package com.victor.banknotescalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.victor.banknotescalculator.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {

            val note1 = Integer.parseInt(binding.note1.text.toString())
            val note2 = Integer.parseInt(binding.note2.text.toString())
            val note3 = Integer.parseInt(binding.note3.text.toString())
            val note4 = Integer.parseInt(binding.note4.text.toString())
            val falts = Integer.parseInt(binding.falts.text.toString())
            val result = binding.txtResult
            val average = (note1 + note2 + note3 + note4) / 4

            if(average >= 5 && falts <= 20) {
                result.text = "The student passed \n Final Average $average".capitalize()
                result.setTextColor(getColor(R.color.green))
            } else if(falts > 20){
                result.text = "The was disapproved by falts \n Average $average".capitalize()
                result.setTextColor(getColor(R.color.red))
            } else if(average < 5) {
                result.text = "The was disapproved by notes \n final note $average".capitalize()
                result.setTextColor(getColor(R.color.red))
            }
        }
    }
}