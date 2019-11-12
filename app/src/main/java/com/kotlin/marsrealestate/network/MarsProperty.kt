package com.kotlin.marsrealestate.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

// SOS: to pass this class as an arg to the DetailFragment, I have to make it Parcelizable. Doing so
// is VERY easy in Kotlin. Just annotate w @Parcelize and then declare that it implements Parcelable!
@Parcelize
data class MarsProperty(
        val id: String,
        @Json(name = "img_src") val imgSrcUrl: String,
        val type: String,
        val price: Double) : Parcelable {

    val isRental
        get() = type == "rent"
}
