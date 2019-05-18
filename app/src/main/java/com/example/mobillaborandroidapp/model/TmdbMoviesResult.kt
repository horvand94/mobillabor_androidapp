package com.example.mobillaborandroidapp.model

import com.google.gson.annotations.SerializedName


data class TmdbMoviesResult(
    @SerializedName("tmdb_movies")
    var tmdbMovies: TmdbMovies? = null
)