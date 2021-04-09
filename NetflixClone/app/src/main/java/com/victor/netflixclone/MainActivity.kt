  package com.victor.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide() // esconder a status bar

        Handler(Looper.getMainLooper()).postDelayed({
            openScreenLogin()
        }, 2000)
    }

    private fun openScreenLogin() {
        val loginScreen = Intent(this, FormLogin::class.java)
        startActivity(loginScreen)
        finish()
    }
}