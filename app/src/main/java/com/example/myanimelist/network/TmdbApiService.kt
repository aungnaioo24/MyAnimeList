package com.example.myanimelist.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL = "https://api.themoviedb.org"

// Build the Moshi object with Kotlin adapter factory that Retrofit will be using
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// The Retrofit object with the Moshi converter
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface TmdbApiService {
    @GET("3/tv/popular?api_key=d3e545c3c1c8223dfeb81e07106149a5&with_genres=16&with_original_language=ja&page=1")
    fun getAnimeSeries():
            Call<List<AnimeSeries>>
}

object TmdbApi {
    val retrofitService: TmdbApiService by lazy { retrofit.create(TmdbApiService::class.java) }
}