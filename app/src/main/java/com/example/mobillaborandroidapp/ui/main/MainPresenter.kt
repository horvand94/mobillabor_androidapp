package com.example.mobillaborandroidapp.ui.main

import com.example.mobillaborandroidapp.ui.Presenter

class MainPresenter : Presenter<MainScreen>() {

    fun showMovies() {}
    fun showMovieDetails(movieId: Int) {}
    fun deleteMovie(movieId: Int) {}
    fun rateMovie(movieId: Int) {}
    fun addMovie() {}
}