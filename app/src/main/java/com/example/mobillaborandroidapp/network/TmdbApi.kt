package com.example.mobillaborandroidapp.network

import com.example.mobillaborandroidapp.model.TmdbMovies
import com.example.mobillaborandroidapp.model.TmdbMoviesResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TmdbApi {
    @GET("search/movie")
    fun getMoviesFromTmdb(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("include_adult") include_adult: String) : Call<TmdbMovies>
}