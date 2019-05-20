package com.example.mobillaborandroidapp

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
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideMainPresenter(executor: Executor, moviesInteractor: MoviesInteractor) = MainPresenter(executor, moviesInteractor)

    @Provides
    @Singleton
    fun provideMoviePresenter(executor: Executor, moviesInteractor: MoviesInteractor) = MoviePresenter(executor, moviesInteractor)

    @Provides
    @Singleton
    fun provideAddMoviePresenter(executor: Executor, moviesInteractor: MoviesInteractor) = AddMoviePresenter(executor, moviesInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = Executors.newFixedThreadPool(1)
}