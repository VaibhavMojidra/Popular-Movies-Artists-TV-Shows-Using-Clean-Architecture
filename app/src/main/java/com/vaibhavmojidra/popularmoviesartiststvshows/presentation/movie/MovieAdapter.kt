package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vaibhavmojidra.popularmoviesartiststvshows.R
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.movie.Movie
import com.vaibhavmojidra.popularmoviesartiststvshows.databinding.ListItemBinding

class MovieAdapter(): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val movieList= ArrayList<Movie>()

    fun setList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding:ListItemBinding=DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    class MovieViewHolder(val binding:ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie:Movie){
            binding.titleTextView.text=movie.title
            binding.descriptionTextView.text=movie.overview
            val posterURl="https://image.tmdb.org/t/p/w500/"+movie.posterPath
            Glide.with(binding.imageView.context)
                .load(posterURl)
                .into(binding.imageView)
        }
    }
}