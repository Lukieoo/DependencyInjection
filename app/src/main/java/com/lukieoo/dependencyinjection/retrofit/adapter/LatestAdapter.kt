package com.lukieoo.dependencyinjection.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukieoo.dependencyinjection.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_latest.view.*

class LatestAdapter:RecyclerView.Adapter<ViewHolder>() {

    lateinit var items: ArrayList<com.lukieoo.dependencyinjection.retrofit.model.Result>

    fun setPosts(items: List<com.lukieoo.dependencyinjection.retrofit.model.Result>) {
        this.items = items as ArrayList<com.lukieoo.dependencyinjection.retrofit.model.Result>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_latest, parent, false))
    }

    override fun getItemCount(): Int {
        if(::items.isInitialized){

            return items.size
        }else{
            return 0
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var model=items.get(position)
        Picasso.get()
            .load(model.background_image)
            .resize(400,300)
            .into( holder.photoGame);
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each image to
    val photoGame = view.photoGame

}