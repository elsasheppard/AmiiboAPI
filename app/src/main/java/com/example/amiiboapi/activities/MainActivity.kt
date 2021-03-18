package com.example.amiiboapi.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.amiiboapi.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_main_enterSearch.setOnClickListener {
            val specificTextIntent = Intent(this@MainActivity, AmiiboListActivity::class.java)
            specificTextIntent.putExtra(AmiiboListActivity.EXTRA_SEARCH, etSearch.text.toString())
            startActivity(specificTextIntent)
        }

    }


    // val specificAmiiboIntent = Intent(itemView.context, AmiiboDetailActivity::class.java)
    //                specificAmiiboIntent.putExtra(AmiiboDetailActivity.EXTRA_AMIIBO, amiibo)
    // string extra
}