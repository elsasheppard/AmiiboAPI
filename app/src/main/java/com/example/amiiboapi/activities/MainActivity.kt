package com.example.amiiboapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.amiiboapi.R
import com.example.amiiboapi.models.AmiiboWrapper
import com.example.amiiboapi.services.AmiiboService
import com.example.amiiboapi.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun loadAmiibos() {
        // initiate the service
        val destinationService = ServiceBuilder.buildService(AmiiboService::class.java)

        // below - one way user input could be utilized to search for a specific amiibo
        // check if they didn't type anything, and give default if so
            // val amiibo = edittext.text.toString()
                // .getAmiiboList(amiibo)
        val requestCall = destinationService.getAmiiboList("link")

        requestCall.enqueue(object : Callback<AmiiboWrapper> {
            override fun onResponse(call: Call<AmiiboWrapper>, response: Response<AmiiboWrapper>) {
                val myAmiibo = response.body() ?: emptyList<AmiiboWrapper>()
                Log.d(TAG, "onResponse: " + myAmiibo)
            }

            override fun onFailure(call: Call<AmiiboWrapper>, t: Throwable) {
                TODO("Not yet implemented")
                Log.d(TAG, "onFailure" + t.message)
            }
        } )
    }
}