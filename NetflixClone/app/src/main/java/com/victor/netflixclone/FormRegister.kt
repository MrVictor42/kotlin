package com.victor.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.victor.netflixclone.databinding.ActivityFormRegisterBinding

class FormRegister : AppCompatActivity() {

    private lateinit var binding: ActivityFormRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.btnRegister.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val message = binding.message

            if(email.isEmpty() || password.isEmpty()) {
                message.text = "Fill All Fields!"
            } else {
                registerUser()
            }
        }
    }

    private fun registerUser() {
        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()
        val message = binding.message

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful) {
                Toast.makeText(this, "Registered User Successfully!", Toast.LENGTH_SHORT).show()
                binding.editEmail.setText("")
                binding.editPassword.setText("")
                message.text = ""
            }
        }.addOnFailureListener {
            var error = it

            when {
                error is FirebaseAuthWeakPasswordException -> message.text = "Insert a Password With 6 no Minimum Characters"
                error is FirebaseAuthUserCollisionException -> message.text = "This Account Already Registrated!"
                error is FirebaseNetworkException -> message.text = "Without Connection With Internet"
                else -> message.text = "Error Registrated User"
            }
        }
    }
}