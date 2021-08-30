package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.artist

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
import com.vaibhavmojidra.popularmoviesartiststvshows.databinding.ActivityArtistBinding
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel:ArtistViewModel
    private lateinit var binding: ActivityArtistBinding
    private lateinit var adapter:ArtistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel=ViewModelProvider(this,factory).get(ArtistViewModel::class.java)
        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater =menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update->{
                updatePopularArtists()
                true
            }else->super.onOptionsItemSelected(item)
        }
    }
    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager= LinearLayoutManager(this)
        adapter= ArtistAdapter()
        binding.movieRecyclerView.adapter=adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        binding.movieRecyclerView.visibility= View.GONE
        binding.movieProgressBar.visibility= View.VISIBLE
        val responseLiveData=artistViewModel.getArtists()
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

    private fun updatePopularArtists() {
        binding.movieRecyclerView.visibility= View.GONE
        binding.movieProgressBar.visibility= View.VISIBLE
        val responseLiveData=artistViewModel.updateArtists()
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