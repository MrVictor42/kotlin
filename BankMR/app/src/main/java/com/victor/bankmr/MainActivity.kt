package com.victor.bankmr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.victor.bankmr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.balanceID.setOnClickListener {
            val intent = Intent(this, Balance::class.java) // This is to chance screens
            startActivity(intent)
            finish()
        }

        binding.invoiceID.setOnClickListener {
            val intent = Intent(this, Invoice::class.java)
            startActivity(intent)
            finish()
        }

        binding.transferID.setOnClickListener {
            val intent = Intent(this, Transfer::class.java)
            startActivity(intent)
            finish()
        }

        binding.savingsID.setOnClickListener {
            val intent = Intent(this, Savings::class.java)
            startActivity(intent)
            finish()
        }
    }
}