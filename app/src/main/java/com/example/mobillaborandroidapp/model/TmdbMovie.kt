package com.example.mobillaborandroidapp.model

import com.google.gson.annotations.SerializedName

data class TmdbMovie (
    @SerializedName("vote_count")
    var vote_count: Int? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("video")
    var video: Boolean? = null,
    @SerializedName("vote_average")
    var vote_average: Double? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("popularity")
    var popularity: Double? = null,
    @SerializedName("poster_path")
    var poster_path: String? = null,
    @SerializedName("original_language")
    var original_language: String? = null,
    @SerializedName("original_title")
    var original_title: String? = null,
    @SerializedName("genre_ids")
    var genre_ids: MutableList<Int>? = null,
    @SerializedName("backdrop_path")
    var backdrop_path: String? = null,
    @SerializedName("adult")
    var adult: Boolean? = null,
    @SerializedName("overview")
    var overview: String? = null,
    @SerializedName("release_date")
    var release_date: String? = null

)

