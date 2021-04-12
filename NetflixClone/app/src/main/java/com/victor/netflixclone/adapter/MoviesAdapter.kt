package com.victor.netflixclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.victor.netflixclone.databinding.ListMoviesBinding
import com.victor.netflixclone.model.Movies

class MoviesAdapter(val movies: MutableList<Movies>): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ListMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) { //position itens in list
        with(holder) {
            with(movies[position]) {
                binding.capaMovie.setImageResource(capaMovie)
            }
        }
    }

    override fun getItemCount() = movies.size

    inner class MoviesViewHolder(val binding: ListMoviesBinding): RecyclerView.ViewHolder(binding.root) {

    }
}