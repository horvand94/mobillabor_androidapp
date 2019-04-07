package com.example.mobillaborandroidapp.ui.movie

import com.example.mobillaborandroidapp.interactor.movies.MoviesInteractor
import com.example.mobillaborandroidapp.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class MoviePresenter @Inject constructor(private val executor: Executor, private val moviesInteractor: MoviesInteractor) : Presenter<MovieScreen>() {

    fun getMovieDetails(movieTitle: String) {}
    fun showDetails(movieId: Int) {}
}