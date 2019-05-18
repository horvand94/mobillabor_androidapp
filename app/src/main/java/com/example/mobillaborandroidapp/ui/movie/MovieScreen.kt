package com.example.mobillaborandroidapp.ui.movie

import com.example.mobillaborandroidapp.model.Movie

interface MovieScreen {
    fun showDetails(movie: Movie)
    fun showNetworkError(errorMsg: String)
}