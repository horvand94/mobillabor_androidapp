package com.example.mobillaborandroidapp.interactor.movies

import android.util.Log
import com.example.mobillaborandroidapp.interactor.movies.event.GetMovieEvent
import com.example.mobillaborandroidapp.interactor.movies.event.GetMoviesEvent
import com.example.mobillaborandroidapp.network.MoviesApi
import com.example.mobillaborandroidapp.network.TokenApi
import com.example.mobillaborandroidapp.model.Movie
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class MoviesInteractor @Inject constructor(private var moviesApi: MoviesApi) {

    fun getMovies() {
        val event = GetMoviesEvent()
        try {
            val moviesQueryCall = moviesApi.movies

            val response = moviesQueryCall.execute()
            Log.d("Response", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.movies = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun addMovie(movie: Movie) {
        val addMovieQueryCall = moviesApi.addMovie(movie)
        addMovieQueryCall.execute()
    }

    fun getMovieById(movieId: Long) {
        val event = GetMovieEvent()
        try {
            val getMovieByIdQueryCall = moviesApi.getMovieById(movieId)
            val response = getMovieByIdQueryCall.execute()

            Log.d("Response", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.movie = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun updateMovieRating(movieId: Long, movie: Movie) {
        val updateMovieRatingQueryCall = moviesApi.updateMovieRating(movieId, movie)
        updateMovieRatingQueryCall.execute()
    }

    fun deleteMovie(movieId: Long)
    {
        val deleteMovieQueryCall = moviesApi.deleteMovie(movieId)
        deleteMovieQueryCall.execute()
    }




}