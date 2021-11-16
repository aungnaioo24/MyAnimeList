package com.example.myanimelist.network

import com.squareup.moshi.Json

data class AnimeSeries (
    val page: Int,
    val results: List<Serie>
)

data class Serie (
    val id: Int,
    val name: String,
    val overview: String,
    val first_air_date: String,
    @Json(name = "poster_path") val imgSrcUrl: String
)