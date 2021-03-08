package com.example.amiiboapi.activities

import android.os.Bundle
import android.util.Log
import com.example.amiiboapi.R
import com.example.amiiboapi.models.Amiibo

class AmiiboDetailActivity {

    val TAG = "AmiiboDetailActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amiibo_detail)

        val amiibo = intent.getParcelableExtra<Amiibo>(EXTRA_AMIIBO)
        Log.d(TAG, "onCreate" + amiibo)
    }

    companion object {

    }
}