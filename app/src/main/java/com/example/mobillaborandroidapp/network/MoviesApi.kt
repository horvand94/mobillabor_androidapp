package com.example.mobillaborandroidapp.network

import com.example.mobillaborandroidapp.model.Movie
import retrofit2.Call
import retrofit2.http.*

import okhttp3.RequestBody


import java.util.ArrayList
import java.util.HashMap

interface MoviesApi {

    /**
     * Find all movies
     * Returns all movies
     * @return Call<List></List><Movie>>
    </Movie> */

    @get:GET("Movies")
    val movies: Call<List<Movie>>


    /**
     * Add a new movie to the list
     *
     * @param body Movie object that needs to be added to the list
     * @return Call<Void>
    </Void> */

    @POST("Movies")
    fun addMovie(
        @Body body: Movie
    ): Call<Void>


    /**
     * Find movie by ID
     * Returns a single movie
     * @param movieId ID of movie to return
     * @return Call<Movie>
    </Movie> */

    @GET("Movies/{movieId}")
    fun getMovieById(
        @Path("movieId") movieId: Long?
    ): Call<Movie>


    /**
     * Updates a movie in the list with new rating
     *
     * @param movieId ID of movie that needs to be updated
     * @param body Updated movie object
     * @return Call<Void>
    </Void> */

    @PUT("Movies/{movieId}")
    fun updateMovieRating(
        @Path("movieId") movieId: Long?, @Body body: Movie
    ): Call<Void>


    /**
     * Deletes a movie
     *
     * @param movieId Movie id to delete
     * @return Call<Void>
    </Void> */

    @DELETE("Movies/{movieId}")
    fun deleteMovie(
        @Path("movieId") movieId: Long?
    ): Call<Void>


}
