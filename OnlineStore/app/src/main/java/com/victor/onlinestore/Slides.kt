package com.victor.onlinestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide

class Slides : IntroActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addSlide(
            SimpleSlide.Builder()
                .background(R.color.purple)
                .image(R.drawable.drawer)
                .title("Online Store of Shoes")
                .description("Enter And Check The Promotions We Have Prepared For You!")
                .build()
        )

        addSlide(
            SimpleSlide.Builder()
                .background(R.color.blue_green)
                .title("Create a Free Account")
                .description("Register Right Now! And Come Meet Our Products!")
                .build()
        )
    }
}