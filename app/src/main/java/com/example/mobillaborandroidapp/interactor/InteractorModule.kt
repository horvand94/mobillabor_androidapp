package com.example.mobillaborandroidapp.interactor

import com.example.mobillaborandroidapp.interactor.movies.MoviesInteractor
import com.example.mobillaborandroidapp.network.MoviesApi
import com.example.mobillaborandroidapp.network.TokenApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideMoviesInteractor(moviesApi: MoviesApi, tokenApi: TokenApi) = MoviesInteractor(moviesApi, tokenApi)
}