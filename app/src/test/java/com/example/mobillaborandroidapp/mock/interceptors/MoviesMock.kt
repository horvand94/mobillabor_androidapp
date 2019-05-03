package com.example.mobillaborandroidapp.mock.interceptors

import android.net.Uri
import com.example.mobillaborandroidapp.model.Movie
import com.example.mobillaborandroidapp.network.NetworkConfig
import com.google.gson.Gson;
import okhttp3.Request
import okhttp3.Response

object MoviesMock {



    const val ID1 = 1L
    const val TITLE1 = "Inception"
    const val GENRE1 = "Action, Sci-fi"
    const val POSTERURL1 = "/qmDpIHrmpJINaRKAfWQfftjCdyi.jpg"
    const val RATING1 = 10
    const val RELEASEYEAR1 = 2010
    const val RUNTIME1 = 148
    const val DIRECTOR1 = "Christopher Nolan"
    var CAST1 = ArrayList<String>();

    fun process(request: Request): Response {
        val uri = Uri.parse(request.url().toString())

        val responseString: String
        val responseCode: Int
        val headers = request.headers()

        if (uri.path == NetworkConfig.ENDPOINT_PREFIX + "Movies" && request.method() == "GET") {
            CAST1.add("Leonardo DiCaprio");
            CAST1.add("Joseph Gordon-Levitt");
            CAST1.add("Ellen Page");

            val movieList = listOf(
                Movie(ID1, TITLE1, GENRE1, POSTERURL1, RATING1, RELEASEYEAR1, RUNTIME1, DIRECTOR1, CAST1)
            )

            var gson = Gson()
            responseString = gson.toJson(movieList)
            responseCode = 200
        } else {
            responseString = "ERROR"
            responseCode = 503
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString)
    }

}