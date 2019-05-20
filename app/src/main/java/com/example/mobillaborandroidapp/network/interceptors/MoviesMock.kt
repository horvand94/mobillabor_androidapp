package com.example.mobillaborandroidapp.network.interceptors

import com.example.mobillaborandroidapp.model.Movie

object MoviesMock {

    var movieList : ArrayList<Movie> = ArrayList<Movie>()


    const val ID1 = 1L
    const val TITLE1 = "Inception"
    const val GENRE1 = "Action, Sci-fi"
    const val POSTERURL1 = "/qmDpIHrmpJINaRKAfWQfftjCdyi.jpg"
    const val RATING1 = 10.0
    const val RELEASEDATE1 = "2010"
    const val OVERVIEW1 = "Great movie"
    const val RUNTIME1 = 148
    const val DIRECTOR1 = "Christopher Nolan"
    var CAST1 = ArrayList<String>();

    const val ID2 = 1L
    const val TITLE2 = "The Hangover"
    const val GENRE2 = "Comedy"
    const val POSTERURL2 = "/uluhlXubGu1VxU63X9VHCLWDAYP.jpg"
    const val RATING2 = 10.0
    const val RELEASEDATE2 = "2009"
    const val OVERVIEW2 = "Great comedy"
    const val RUNTIME2 = 100
    const val DIRECTOR2 = "Todd Phillips"
    var CAST2 = ArrayList<String>();

    fun loadMovieList() {
        CAST1.add("Leonardo DiCaprio");
        CAST1.add("Joseph Gordon-Levitt");
        CAST1.add("Ellen Page");

        CAST2.add("Bradley Cooper");
        CAST2.add("Ed Helms");
        CAST2.add("Zach Galifianakis");


        if(movieList.isEmpty())
        {
            movieList.add(Movie(ID1, TITLE1, GENRE1, POSTERURL1, RATING1.toFloat(), RELEASEDATE1, OVERVIEW1, RUNTIME1, DIRECTOR1, CAST1))
            movieList.add(Movie(ID2, TITLE2, GENRE2, POSTERURL2, RATING2.toFloat(), RELEASEDATE2, OVERVIEW2, RUNTIME2, DIRECTOR2, CAST2))
        }
    }

    fun addMovie(movie: Movie) {
        movieList.add(movie)
    }

    fun getMovieById(movieId: Int?): Movie {
        return movieList[movieId!!]
    }

    fun updateMovieRating(movieId: Int?, rating: Float) {
        var movie = movieList[movieId!!]
        movie.rating = rating
    }

    fun deleteMovie(movieId: Int?) {
        movieList.removeAt(movieId!!)
    }
}