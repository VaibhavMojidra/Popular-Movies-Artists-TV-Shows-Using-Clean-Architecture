package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vaibhavmojidra.popularmoviesartiststvshows.R
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.artist.Artist
import com.vaibhavmojidra.popularmoviesartiststvshows.databinding.ListItemBinding

class ArtistAdapter():RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {
    private val artistList= ArrayList<Artist>()

    fun setList(artists:List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding:ListItemBinding=
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int =artistList.size

    class ArtistViewHolder(val binding: ListItemBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(artist:Artist){
            binding.titleTextView.text=artist.name
            binding.descriptionTextView.text=artist.popularity.toString()
            val profileURl="https://image.tmdb.org/t/p/w500/"+artist.profilePath
            Glide.with(binding.imageView.context).load(profileURl).into(binding.imageView)
        }
    }
}