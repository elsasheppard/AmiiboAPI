package com.example.amiiboapi.services

import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.GET
import retrofit2.http.Query


interface TestService {

    @GET("amiibo/")
    fun getAmiiboByName(@Query("name") name:String) : android.telecom.Call<>
}

// this is to search the api for a string using user input
destinationSerivce.getAmiiboByName(edittext.text.toString())