package com.example.mobillaborandroidapp.repository

import android.content.Context
import com.example.mobillaborandroidapp.model.Movie
import com.google.common.collect.Iterables.removeAll
import javax.inject.Inject

class MemoryRepository @Inject constructor() : Repository {

    companion object {
        var movies = mutableListOf(
            Movie(
                title = "Example 1",
                genre = "Genre 1",
                id = 1L
            ),
            Movie(
                title = "Example 1",
                genre = "Genre 1",
                id = 1L
            ),
            Movie(
                title = "Example 1",
                genre = "Genre 1",
                id = 1L
            )
        )
    }

    override fun open(context: Context) {
        // Empty
    }

    override fun close() {
        // Empty
    }

    override fun getMovies(): MutableList<Movie> {
        return movies
    }

    override fun saveMovie(movie: Movie) {
        movies.add(movie)
    }

    override fun updateMovies(movies: MutableList<Movie>) {
        movies.forEach { movie ->
            val removed = movies.removeAll {it -> it.id == movie.id}
            if (removed) {
                movies.add(movie)
            }
        }
    }

    override fun removeMovie(movie: Movie) {
        movies.remove(movie)
    }

    override fun isMovie(movie: Movie): Boolean {
        return movies.contains(movie)
    }
}