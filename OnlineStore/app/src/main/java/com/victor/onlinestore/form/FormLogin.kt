package com.victor.onlinestore.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.victor.onlinestore.R

class FormLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        supportActionBar!!.hide()
    }
}