package com.example.universitylist.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class University(
    @Json( name = "alpha_two_code" ) val country_code : String, val country : String, val name : String,
    @Json( name = "state-province")val state : String?,
    val domains : List<String> , val web_pages : List<String> ) : Parcelable