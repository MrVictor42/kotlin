package com.victor.onlinestore.form

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.victor.onlinestore.R
import com.victor.onlinestore.databinding.ActivityFormRegisterBinding

class FormRegister : AppCompatActivity() {

    private lateinit var binding: ActivityFormRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.btnRegister.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()

        if(email.isEmpty() || password.isEmpty()) {
            val snarckbar = Snackbar.make(binding.layoutRegister, "Inform Your Email And Your Password!", Snackbar.LENGTH_INDEFINITE)
            snarckbar.setBackgroundTint(Color.WHITE).setTextColor(Color.BLACK).setAction("OK", View.OnClickListener {

            })
            snarckbar.show()
        } else {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if(it.isSuccessful) {
                    val snarckbar = Snackbar.make(binding.layoutRegister, "User Successfully Registered!", Snackbar.LENGTH_INDEFINITE)
                    snarckbar.setBackgroundTint(Color.WHITE).setTextColor(Color.BLACK).setAction("OK", View.OnClickListener {
                        backToLogin()
                    })
                    snarckbar.show()
                }
            }.addOnFailureListener {
                val snarckbar = Snackbar.make(binding.layoutRegister, "Error When Registering User!", Snackbar.LENGTH_INDEFINITE)
                snarckbar.setBackgroundTint(Color.WHITE).setTextColor(Color.BLACK).setAction("OK", View.OnClickListener {

                })
                snarckbar.show()
            }
        }
    }

    private fun backToLogin() {
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}