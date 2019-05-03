package com.example.mobillaborandroidapp.repository

import android.content.Context
import com.example.mobillaborandroidapp.model.Movie

interface Repository {

    fun getMovies(): MutableList<Movie>

    fun open(context: Context)

    fun close()

    fun saveMovie(movie: Movie)

    fun updateMovies(movies: MutableList<Movie>)

    fun removeMovie(movie: Movie)

    fun isMovie(movie: Movie): Boolean

}