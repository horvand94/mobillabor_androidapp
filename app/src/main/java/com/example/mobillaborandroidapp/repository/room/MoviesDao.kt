package com.example.mobillaborandroidapp.repository.room

import androidx.room.*
import com.example.mobillaborandroidapp.model.Movie


@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies")
    fun getMovies(): MutableList<Movie>

    @Insert
    fun saveMovie(movie: Movie)

    @Update
    fun updateMovies(movies: MutableList<Movie>)

    @Delete
    fun removeMovie(movie: Movie)

    @Query("SELECT * FROM movies WHERE id = :id")
    fun findMovieById(id: Long?): Movie?

}