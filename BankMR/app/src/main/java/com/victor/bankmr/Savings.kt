package com.victor.bankmr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.victor.bankmr.databinding.ActivitySavingsBinding
import com.victor.bankmr.databinding.ActivityTransferBinding

class Savings : AppCompatActivity() {

    private lateinit var binding: ActivitySavingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val toolbar = binding.toolbarSavings
        toolbar.title = "Savings"
        toolbar.setTitleTextColor(getColor(R.color.white))
        toolbar.setTitleMargin(300, 0, 300, 0)
        toolbar.setBackgroundColor(getColor(R.color.light_blue))
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_back))
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}