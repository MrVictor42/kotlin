package com.victor.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.squareup.picasso.Picasso
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

        val capaTheWitcher = "https://firebasestorage.googleapis.com/v0/b/netflix-clone42.appspot.com/o/video.jpg?alt=media&token=9acb85d0-68e4-4000-bd4a-d095d62ac977"
        Picasso.get().load(capaTheWitcher).fit().into(binding.capa)
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