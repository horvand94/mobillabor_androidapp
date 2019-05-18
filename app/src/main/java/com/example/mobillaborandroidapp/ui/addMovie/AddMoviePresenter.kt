package com.example.mobillaborandroidapp.ui.addMovie

import com.example.mobillaborandroidapp.interactor.movies.MoviesInteractor
import com.example.mobillaborandroidapp.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class AddMoviePresenter @Inject constructor(private val executor: Executor, private val moviesInteractor: MoviesInteractor) :  Presenter<AddMovieScreen>() {

    fun addMovieToList(query: String, rating: Float) {
        executor.execute {
            moviesInteractor.addMovie(query, rating)
        }
    }
}