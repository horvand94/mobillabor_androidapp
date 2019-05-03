package com.example.mobillaborandroidapp.mock.interceptors

import android.net.Uri
import android.util.Log
import com.example.mobillaborandroidapp.network.NetworkConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return process(chain.request())
    }

    private fun process(request: Request): Response {
        val uri = Uri.parse(request.url().toString())

        Log.d("Test Http Client", "URL call: $uri")

        val headers = request.headers()

        val path = uri.path

        return when {
            path == null -> MockHelper.makeResponse(request, headers, 404, "Unknown")
            path.startsWith(NetworkConfig.ENDPOINT_PREFIX + "Movies") -> MoviesMock.process(request)
            else -> MockHelper.makeResponse(request, headers, 404, "Unknown")
        }
    }

}