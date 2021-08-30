package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import com.vaibhavmojidra.popularmoviesartiststvshows.databinding.ActivityTvShowBinding
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.Injector
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.movie.MovieAdapter
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory:TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var adapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent().inject(this)
        tvShowViewModel=ViewModelProvider(this,factory).get(TvShowViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager= LinearLayoutManager(this)
        adapter= TvShowAdapter()
        binding.movieRecyclerView.adapter=adapter
        displayPopularTvShows()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater =menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update->{
                updatePopularTvShows()
                true
            }else->super.onOptionsItemSelected(item)
        }
    }
    private fun displayPopularTvShows(){
        binding.movieRecyclerView.visibility= View.GONE
        binding.movieProgressBar.visibility= View.VISIBLE
        val responseLiveData=tvShowViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"No Data Available", Toast.LENGTH_LONG).show()
            }
            binding.movieProgressBar.visibility= View.GONE
            binding.movieRecyclerView.visibility= View.VISIBLE
        })
    }

    private fun updatePopularTvShows(){
        binding.movieRecyclerView.visibility= View.GONE
        binding.movieProgressBar.visibility= View.VISIBLE
        val responseLiveData=tvShowViewModel.updateTvShows()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"No Data Available", Toast.LENGTH_LONG).show()
            }
            binding.movieProgressBar.visibility= View.GONE
            binding.movieRecyclerView.visibility= View.VISIBLE
        })
    }
}