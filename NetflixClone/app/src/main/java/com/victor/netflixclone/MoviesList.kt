package com.victor.netflixclone

import adapter.MoviesAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.victor.netflixclone.databinding.ActivityMoviesListBinding
import com.victor.netflixclone.model.addMovies

class MoviesList : AppCompatActivity() {

    private lateinit var binding: ActivityMoviesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerMovies = binding.recyclerview
        recyclerMovies.adapter = MoviesAdapter(addMovies())
        recyclerMovies.layoutManager = GridLayoutManager(applicationContext, 3) //qtde columns in list
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.logout -> {
                FirebaseAuth.getInstance().signOut()
                backScreenLogin()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun backScreenLogin() {
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}