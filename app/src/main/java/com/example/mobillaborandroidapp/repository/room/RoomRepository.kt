package com.example.mobillaborandroidapp.repository.room

import android.content.Context
import androidx.room.Room
import com.example.mobillaborandroidapp.model.Movie
import com.example.mobillaborandroidapp.repository.Repository
import javax.inject.Inject

class RoomRepository @Inject constructor() : Repository {

    private lateinit var moviesDao: MoviesDao

    override fun open(context: Context) {
        moviesDao = Room.databaseBuilder(context, MyDatabase::class.java, "movies.db").build().roomDao()
    }

    override fun close() {
        // Empty
    }

    override fun getMovies(): MutableList<Movie> {
        return moviesDao.getMovies()
    }

    override fun saveMovie(movie: Movie) {
        moviesDao.saveMovie(movie)
    }

    override fun updateMovies(movies: MutableList<Movie>) {
        moviesDao.updateMovies(movies)
    }

    override fun removeMovie(movie: Movie) {
        moviesDao.removeMovie(movie)
    }

    override fun isMovie(movie: Movie): Boolean {
        return moviesDao.findMovieById(movie.id) != null
    }

}