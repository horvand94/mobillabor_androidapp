package com.example.mobillaborandroidapp.ui.main

import com.example.mobillaborandroidapp.model.Movie

interface MainScreen {
    fun showMovies(movies: List<Movie>?)
    fun showNetworkError(errorMsg: String)
    fun refresh()
}