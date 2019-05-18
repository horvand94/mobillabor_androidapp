package com.example.mobillaborandroidapp.network

import android.util.Log
import com.example.mobillaborandroidapp.mock.interceptors.MockHelper
import com.example.mobillaborandroidapp.mock.interceptors.MoviesMock
import com.example.mobillaborandroidapp.model.Movie
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URL
import javax.inject.Inject

class MockMoviesApi @Inject constructor(private var tmdbApi: TmdbApi) : MoviesApi
{
    override val movies: Call<List<Movie>>
        get() {

            val call = object : Call<List<Movie>> {
                override fun enqueue(callback: Callback<List<Movie>>) {

                }

                override fun isExecuted(): Boolean {
                    return false
                }

                override fun clone(): Call<List<Movie>> {
                    return this
                }

                override fun isCanceled(): Boolean {
                    return false
                }

                override fun cancel() {

                }

                override fun execute(): Response<List<Movie>> {
                    MoviesMock.loadMovieList()
                    return Response.success(MoviesMock.movieList)
                }

                override fun request(): Request? {
                    return null
                }
            }

            return call
        }


    override fun addMovie(title: String, rating: Float): Call<Void> {
        val API_KEY = "f06cd5720a30c821dd303589775bbf1d";
        val call = object : Call<Void> {
            override fun enqueue(callback: Callback<Void>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun clone(): Call<Void> {
                return this
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun execute(): Response<Void?> {

                val tmdbMoviesQueryCall =
                    tmdbApi.getMoviesFromTmdb(api_key = API_KEY, language = "en-US", query = title, page = 1, include_adult = "false")

                val response = tmdbMoviesQueryCall.execute()

                var res = response.body().toString()

                val tmdbMovies = response.body()?.results
                val tmdbMovie = tmdbMovies?.get(0)


                var movie = Movie(tmdbMovie?.id?.toLong(), tmdbMovie?.title, null, tmdbMovie?.poster_path, rating, tmdbMovie?.release_date, tmdbMovie?.overview, null, null, null)



                MoviesMock.addMovie(movie)
                return Response.success(null)
            }

            override fun request(): Request? {
                return null
            }

        }
        return call
    }

    override fun getMovieById(movieId: Int?): Call<Movie> {
        val call = object : Call<Movie> {
            override fun enqueue(callback: Callback<Movie>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun clone(): Call<Movie> {
                return this
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun execute(): Response<Movie?> {
                var movie = MoviesMock.getMovieById(movieId)

                return Response.success(movie)
            }

            override fun request(): Request? {
                return null
            }

        }
        return call
    }

    override fun updateMovieRating(movieId: Int?, rating: Float): Call<Void> {
        val call = object : Call<Void> {
            override fun enqueue(callback: Callback<Void>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun clone(): Call<Void> {
                return this
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun execute(): Response<Void?> {
                MoviesMock.updateMovieRating(movieId, rating)
                return Response.success(null)
            }

            override fun request(): Request? {
                return null
            }

        }
        return call
    }

    override fun deleteMovie(movieId: Int?): Call<Void> {
        val call = object : Call<Void> {
            override fun enqueue(callback: Callback<Void>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun clone(): Call<Void> {
                return this
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun execute(): Response<Void?> {
                MoviesMock.deleteMovie(movieId)
                return Response.success(null)
            }

            override fun request(): Request? {
                return null
            }

        }
        return call
    }

}