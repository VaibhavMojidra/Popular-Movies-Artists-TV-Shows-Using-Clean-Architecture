package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vaibhavmojidra.popularmoviesartiststvshows.R
import com.vaibhavmojidra.popularmoviesartiststvshows.databinding.ActivityMovieBinding
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter:MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel=ViewModelProvider(this,factory).get(MovieViewModel::class.java)
        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update->{
                updatePopularMovies()
                true
            }else->super.onOptionsItemSelected(item)
        }
    }
    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager=LinearLayoutManager(this)
        adapter= MovieAdapter()
        binding.movieRecyclerView.adapter=adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieRecyclerView.visibility=View.GONE
        binding.movieProgressBar.visibility=View.VISIBLE
        val responseLiveData=movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"No Data Available",Toast.LENGTH_LONG).show()
            }
            binding.movieProgressBar.visibility=View.GONE
            binding.movieRecyclerView.visibility=View.VISIBLE
        })
    }

    private fun updatePopularMovies() {
        binding.movieRecyclerView.visibility=View.GONE
        binding.movieProgressBar.visibility=View.VISIBLE
        val responseLiveData=movieViewModel.updateMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"No Data Available",Toast.LENGTH_LONG).show()
            }
            binding.movieProgressBar.visibility=View.GONE
            binding.movieRecyclerView.visibility=View.VISIBLE
        })
    }
}