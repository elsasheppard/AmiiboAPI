package com.example.amiiboapi.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.amiiboapi.R
import com.example.amiiboapi.models.Amiibo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_amiibo_detail.*

class AmiiboDetailActivity : AppCompatActivity() {

    val TAG = "AmiiboDetailActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amiibo_detail)


        val amiibo = intent.getParcelableExtra<Amiibo>(EXTRA_AMIIBO)
        Log.d(TAG, "onCreate" + amiibo)

        Picasso.get().load(amiibo?.image).into(ivBigAmiibo)
    }

    companion object {
        val EXTRA_AMIIBO = "amiibo"
    }
}
