package com.example.mobillaborandroidapp.ui.main

interface MainScreen {
    fun showMovies()
    fun showMovieDetails(movieId: Int)
    fun deleteMovie(movieId: Int)
    fun rateMovie(movieId: Int)
    fun addMovie()
}