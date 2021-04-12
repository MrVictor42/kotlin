package com.victor.netflixclone.model

import com.victor.netflixclone.R

data class Movies (val capaMovie: Int)

class MoviesBuilder {
    var capaMovie: Int = 0

    fun build(): Movies = Movies(capaMovie)
}

fun movies(block: MoviesBuilder.() -> Unit): Movies = MoviesBuilder().apply(block).build()
fun addMovies(): MutableList<Movies> = mutableListOf(

        movies {
            capaMovie = R.drawable.filme1
        },

        movies {
            capaMovie = R.drawable.filme2
        },

        movies {
            capaMovie = R.drawable.filme3
        },

        movies {
            capaMovie = R.drawable.filme4
        },

        movies {
            capaMovie = R.drawable.filme5
        },

        movies {
            capaMovie = R.drawable.filme6
        },

        movies {
            capaMovie = R.drawable.filme7
        },

        movies {
            capaMovie = R.drawable.filme8
        },

        movies {
            capaMovie = R.drawable.filme9
        },

        movies {
            capaMovie = R.drawable.filme10
        },

        movies {
            capaMovie = R.drawable.filme11
        },

        movies {
            capaMovie = R.drawable.filme12
        }
)
