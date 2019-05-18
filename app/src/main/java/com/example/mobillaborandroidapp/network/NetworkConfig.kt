package com.example.mobillaborandroidapp.network

@Suppress("MemberVisibilityCanBePrivate")
object NetworkConfig {
    const val ENDPOINT_ADDRESS = "https://moviesmock.com"
    const val ENDPOINT_PREFIX = "/api/"
    const val SERVICE_ENDPOINT = ENDPOINT_ADDRESS + ENDPOINT_PREFIX
    const val TMDB_ENDPOINT_ADDRESS = "https://api.themoviedb.org/3/"
}