package com.example.myanimelist.network

import com.squareup.moshi.Json

data class AnimeSeries (
    val id: Int,
    val name: String,
    val overview: String,
    @Json(name = "poster_path") val imgSrcUrl: String
)