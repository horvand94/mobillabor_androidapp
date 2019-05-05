package com.example.mobillaborandroidapp.ui.main

import com.example.mobillaborandroidapp.model.Movie

interface MainScreen {
    fun showMovies(movies: List<Movie>?)
    fun showMovieDetails(movieId: Int)
    fun deleteMovie(movieId: Int)
    fun rateMovie(movieId: Int)
    fun addMovie()
    fun showNetworkError(errorMsg: String)
}