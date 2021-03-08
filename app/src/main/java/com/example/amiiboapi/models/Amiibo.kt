package com.example.amiiboapi.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// TODO: finish this

@Parcelize
data class Amiibo(
    val amiiboSeries: String,
    val character: String,
    val gameSeries: String,
    val image: String,
    val name: String,
) : Parcelable
