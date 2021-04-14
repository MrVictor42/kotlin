package com.victor.onlinestore.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.victor.onlinestore.R
import com.victor.onlinestore.databinding.ActivityFormLoginBinding
import com.victor.onlinestore.databinding.ActivityFormRegisterBinding

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.registerText.setOnClickListener {
            val intent = Intent(this, FormRegister::class.java)
            startActivity(intent)
        }
    }
}