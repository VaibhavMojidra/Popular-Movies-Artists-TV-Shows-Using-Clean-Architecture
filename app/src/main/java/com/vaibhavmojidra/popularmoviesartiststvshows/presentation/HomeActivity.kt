package com.vaibhavmojidra.popularmoviesartiststvshows.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.vaibhavmojidra.popularmoviesartiststvshows.R
import com.vaibhavmojidra.popularmoviesartiststvshows.databinding.ActivityHomeBinding
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.artist.ArtistActivity
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.movie.MovieActivity
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.artistBtn.setOnClickListener{
            startActivity(Intent(this,ArtistActivity::class.java))
        }
        binding.movieBtn.setOnClickListener{
            startActivity(Intent(this,MovieActivity::class.java))
        }
        binding.tvShowBtn.setOnClickListener{
            startActivity(Intent(this,TvShowActivity::class.java))
        }
    }
}