package com.example.mobillaborandroidapp.model

import com.google.gson.annotations.SerializedName

data class TmdbMovies(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("total_results")
    var total_results: Int? = null,
    @SerializedName("total_pages")
    var total_pages: Int? = null,
    @SerializedName("results")
    var results: List<TmdbMovie>? = null
)