package com.victor.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.victor.netflixclone.adapter.MoviesAdapter
import com.victor.netflixclone.databinding.ActivityDetailMovieBinding
import com.victor.netflixclone.model.addMovies

class DetailMovie : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        toolbar()

        val recyclerOtherMovies = binding.recyclerOthersMovies
        recyclerOtherMovies.adapter = MoviesAdapter(addMovies())
        recyclerOtherMovies.layoutManager = GridLayoutManager(applicationContext, 3)
    }

    private fun toolbar() {
        val toolbar_details = binding.toolbarDetail
        toolbar_details.setNavigationIcon(getDrawable(R.drawable.ic_back))
        toolbar_details.setNavigationOnClickListener {
            val intent = Intent(this, MoviesList::class.java)
            startActivity(intent)
            finish()
        }
    }
}