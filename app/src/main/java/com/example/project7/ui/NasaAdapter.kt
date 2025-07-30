package com.example.project7.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project7.R
import com.example.project7.data.remote.NasaPhoto

class NasaAdapter : RecyclerView.Adapter<NasaAdapter.NasaViewHolder>() {

    private val items = mutableListOf<NasaPhoto>()

    fun submitList(list: List<NasaPhoto>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nasa, parent, false)
        return NasaViewHolder(view)
    }

    override fun onBindViewHolder(holder: NasaViewHolder, position: Int) {
        val photo = items[position]
        holder.titleText.text = photo.title
        holder.dateText.text = photo.date
        Glide.with(holder.itemView.context)
            .load(photo.url)
            .into(holder.imageView)
    }

    override fun getItemCount() = items.size

    class NasaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.ivPhoto)
        val titleText: TextView = itemView.findViewById(R.id.tvTitle)
        val dateText: TextView = itemView.findViewById(R.id.tvDate)
    }
}





