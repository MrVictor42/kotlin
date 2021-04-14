package com.victor.onlinestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide
import com.victor.onlinestore.form.FormLogin

class Slides : IntroActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isButtonBackVisible = false
        isButtonNextVisible = false

        addSlide(
            SimpleSlide.Builder()
                .background(R.color.purple)
                .image(R.drawable.drawer)
                .backgroundDark(R.color.white)
                .title("Online Store of Shoes")
                .description("Enter And Check The Promotions We Have Prepared For You!")
                .build()
        )

        addSlide(
            SimpleSlide.Builder()
                .background(R.color.blue_green)
                .title("Create a Free Account")
                .canGoBackward(true) //isso é para poder voltar o slide
                .description("Register Right Now! And Come Meet Our Products!")
                .build()
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}