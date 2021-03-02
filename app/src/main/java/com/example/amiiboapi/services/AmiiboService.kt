package com.example.amiiboapi.services

// TODO: make the model class
// import com.example.models.Amiibos
import com.example.amiiboapi.models.AmiiboWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AmiiboService {
    @GET("amiibo/")
    fun getAmiiboList(@Query("name") name : String) : Call<AmiiboWrapper>
}