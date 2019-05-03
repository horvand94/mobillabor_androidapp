package com.example.mobillaborandroidapp.interactor.movies.event

import com.example.mobillaborandroidapp.model.Movie


data class GetMoviesEvent(
    var code: Int = 0,
    var movies: List<Movie>? = null,
    var throwable: Throwable? = null
)