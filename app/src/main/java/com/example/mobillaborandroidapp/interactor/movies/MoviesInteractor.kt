package com.example.mobillaborandroidapp.interactor.movies

import com.example.mobillaborandroidapp.network.MoviesApi
import com.example.mobillaborandroidapp.network.TokenApi
import javax.inject.Inject

class MoviesInteractor @Inject constructor(private var moviesApi: MoviesApi, private var tokenApi: TokenApi) {

    fun getMovies(moviesQuery: String) {}
}