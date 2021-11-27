package com.example.razmovies.network

import com.example.razmovies.data.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.themoviedb.org"
private const val API_KEY = "0583f9ff20a39159f9d5114e1319ee2c"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
// this is Retrofit builder to build and create a Retrofit object.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface MovieApiService {
    @GET("/3/movie/popular?api_key=${API_KEY}")
    suspend fun getMovie(): Response
}

object MovieApi {
    val retrofitService : MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java) }
}
