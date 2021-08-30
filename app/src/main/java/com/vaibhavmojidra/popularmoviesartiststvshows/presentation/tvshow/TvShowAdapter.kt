package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vaibhavmojidra.popularmoviesartiststvshows.R
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.movie.Movie
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow.TVShow
import com.vaibhavmojidra.popularmoviesartiststvshows.databinding.ListItemBinding

class TvShowAdapter():RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder> (){
    private val tvShowList= ArrayList<TVShow>()

    fun setList(tvShows:List<TVShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding:ListItemBinding=
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int=tvShowList.size

    class TvShowViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow:TVShow){
            binding.titleTextView.text=tvShow.name
            binding.descriptionTextView.text=tvShow.overview
            val posterURl="https://image.tmdb.org/t/p/w500/"+tvShow.posterPath
            Glide.with(binding.imageView.context).load(posterURl).into(binding.imageView)
        }
    }
}