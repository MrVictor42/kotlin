package com.victor.onlinestore.form

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
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

        binding.btnLogin.setOnClickListener {
            authenticateUser()
        }
    }

    private fun authenticateUser() {
        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()

        if(email.isEmpty() || password.isEmpty()) {
            val snarckbar = Snackbar.make(binding.layoutLogin, "Inform Your Email and Password!", Snackbar.LENGTH_INDEFINITE)
            snarckbar.setBackgroundTint(Color.WHITE).setTextColor(Color.BLACK).setAction("OK", View.OnClickListener {

            }).setBackgroundTint(Color.WHITE).setTextColor(Color.BLACK).show()
        } else {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if(it.isSuccessful) {

                }
            }
        }
    }
}