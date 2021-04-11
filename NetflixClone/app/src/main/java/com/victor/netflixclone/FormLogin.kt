package com.victor.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.victor.netflixclone.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        userIsAutenticated()

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

    private fun userIsAutenticated() {
        val userLogged = FirebaseAuth.getInstance().currentUser

        if(userLogged != null) {
            goToMovieList()
        }
    }

    private fun authenticateUser(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful) {
                Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_SHORT).show()
                goToMovieList()
            }
        }.addOnFailureListener {
            val error = it
            val messageError = binding.messageError

            when {
                error is FirebaseAuthInvalidCredentialsException -> messageError.text = "Email or Password Are Incorrect"
                error is FirebaseNetworkException -> messageError.text = "Without Connection With Internet"
                else -> messageError.text = "Error Login User"
            }
        }
    }

    private fun goToMovieList() {
        val intent = Intent(this, MoviesList::class.java)
        startActivity(intent)
        finish()
    }
}