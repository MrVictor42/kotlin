package com.app.spotifyclone

import android.content.Intent
import android.graphics.Color
import android.graphics.Picture
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.spotifyclone.Fragments.Home
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes.*

class Detalhes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)


        intent.extras?.let {

            var album = it.getString("album")
            var titulos = it.getString("titulos")

            Picasso.get().load(album).into(detalhe_album)
            titulo_album.setText(titulos)
        }


        window.statusBarColor = Color.LTGRAY
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_arrow_back))
        toolbar.title = null
        toolbar.setNavigationOnClickListener {

            var intent = Intent(this,Home::class.java)
            startActivities(intent)
            finish()
            
        }

    }

    private fun startActivities(intent: Intent) {

    }
}
