package com.example.mobillaborandroidapp.network

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class MockNetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideMoviesApi(client: OkHttpClient, tmdbApi: TmdbApi) : MoviesApi = MockMoviesApi(tmdbApi)

    @Provides
    @Singleton
    fun provideTmdbMoviesApi(client: OkHttpClient) : TmdbApi {
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(NetworkConfig.TMDB_ENDPOINT_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(TmdbApi::class.java)
    }


}