package com.example.mobillaborandroidapp.ui

import android.content.Context
import com.example.mobillaborandroidapp.interactor.movies.MoviesInteractor
import com.example.mobillaborandroidapp.ui.addMovie.AddMoviePresenter
import com.example.mobillaborandroidapp.ui.main.MainPresenter
import com.example.mobillaborandroidapp.ui.movie.MoviePresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, moviesInteractor: MoviesInteractor) = MainPresenter(executor, moviesInteractor)

    @Provides
    @Singleton
    fun moviePresenter(executor: Executor, moviesInteractor: MoviesInteractor) = MoviePresenter(executor, moviesInteractor)

    @Provides
    @Singleton
    fun addMoviePresenter() = AddMoviePresenter()

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)

}