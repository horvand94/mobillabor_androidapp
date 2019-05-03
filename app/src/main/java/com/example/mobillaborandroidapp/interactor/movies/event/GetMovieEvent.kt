package com.example.mobillaborandroidapp.interactor.movies.event

import com.example.mobillaborandroidapp.model.Movie


data class GetMovieEvent(
    var code: Int = 0,
    var movie: Movie? = null,
    var throwable: Throwable? = null
)