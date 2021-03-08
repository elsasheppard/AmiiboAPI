package com.example.amiiboapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.amiiboapi.R
import com.example.amiiboapi.helpers.AmiibosAdapter
import com.example.amiiboapi.models.Amiibo
import com.example.amiiboapi.models.AmiiboWrapper
import com.example.amiiboapi.services.AmiiboService
import com.example.amiiboapi.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadAmiibos()
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
                // Log.d(TAG, "onResponse: " + Amiibo)
                if (response.isSuccessful){
                    val amiiboList = response.body()?.amiibo ?: emptyList<Amiibo>()
                    Log.d(TAG, "onResponse: ${response.body()}")
                    Log.d("Response", "countrylist size : ${amiiboList.size}")
                    amiibo_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@MainActivity,2)
                        adapter = AmiibosAdapter(amiiboList)
                    }
                }else{
                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                    Log.d(TAG,"Something went wrong ${response.message()}")
                }
            }

            override fun onFailure(call: Call<AmiiboWrapper>, t: Throwable) {
                TODO("Not yet implemented")
                Log.d(TAG, "onFailure" + t.message)
            }
        } )
    }
}



//
// 37