package com.kotlin.marsrealestate.network

import com.squareup.moshi.Json

data class MarsProperty(
        val id: String,
        // SOS: changes the initial Moshi property name to whatever we want
        @Json(name = "img_src") val imgSrcUrl: String,
        val type: String,
        val price: Double
)
