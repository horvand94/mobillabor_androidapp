package com.example.mobillaborandroidapp.ui

import android.content.Context
import com.example.mobillaborandroidapp.interactor.movies.MoviesInteractor
import com.example.mobillaborandroidapp.ui.addMovie.AddMoviePresenter
import com.example.mobillaborandroidapp.ui.main.MainPresenter
import com.example.mobillaborandroidapp.ui.movie.MoviePresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter() = MainPresenter()

    @Provides
    @Singleton
    fun moviePresenter(executor: Executor, moviesInteractor: MoviesInteractor) = MoviePresenter()

    @Provides
    @Singleton
    fun addMoviePresenter() = AddMoviePresenter()

}