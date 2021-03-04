package com.example.amiiboapi.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amiiboapi.R
import com.example.amiiboapi.models.Amiibo
import com.example.amiiboapi.models.AmiiboWrapper
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.amiibo_item.view.*
import retrofit2.Call
import java.util.concurrent.RecursiveAction

class AmiibosAdapter(private val amiibosList: List<Amiibo>) : RecyclerView.Adapter<AmiibosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.amiibo_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return amiibosList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count: ${amiibosList.size}")

        return holder.bind(amiibosList[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // linking the individual object to the layout fields in our individual item view
        fun bind(amiibo: Amiibo) {

            // this is all stuff to get info from Amiibo model class into the uhhhhhhh view thing where you see it
            // TODO: replace the countries stuff with amiibo stuff

            itemView.tvCharacter.text = amiibo.character // "tvTitle" is just the text view name
            itemView.tvName.text = amiibo.name          // same here as ^
            itemView.tvAmiiboSeries.text = amiibo.amiiboSeries
            itemView.tvGameSeries.text = amiibo.gameSeries
            Picasso.get().load(amiibo.image).into(itemView.ivAmiibo)
        }

    }

}