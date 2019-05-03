package com.example.mobillaborandroidapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class Movie (

    @PrimaryKey
    @SerializedName("id")
    val id: Long? = null,

    @SerializedName("title")
    @ColumnInfo(name = "title")
    val title: String? = null,

    @SerializedName("genre")
    @ColumnInfo(name = "genre")
    val genre: String? = null,

    @SerializedName("posterUrl")
    @ColumnInfo(name = "posterUrl")
    val posterUrl: String? = null,

    @SerializedName("rating")
    @ColumnInfo(name = "rating")
    val rating: Int? = null,

    @SerializedName("releaseYear")
    @ColumnInfo(name = "releaseYear")
    val releaseYear: Int? = null,

    @SerializedName("runTime")
    @ColumnInfo(name = "runTime")
    val runTime: Int? = null,

    @SerializedName("director")
    @ColumnInfo(name = "director")
    val director: String? = null,

    @SerializedName("cast")
    @ColumnInfo(name = "cast")
    val cast: ArrayList<String>? = null
)