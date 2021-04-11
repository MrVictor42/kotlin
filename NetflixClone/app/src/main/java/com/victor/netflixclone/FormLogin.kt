package com.victor.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.victor.netflixclone.databinding.ActivityFormLoginBinding

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

        binding.btnEnter.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val message = binding.messageError

            if(email.isEmpty() || password.isEmpty()) {
                message.text = "Fill All Fields"
            } else {
                authenticateUser(email, password)
            }
        }
    }

    private fun authenticateUser(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful) {
                Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ListMovies::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener {
            binding.messageError.text = "Error Login User"
        }
    }
}