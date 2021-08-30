package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasourceImpl

import android.util.Log
import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao.MovieDao
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.movie.Movie
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
            Log.i("MyInfo","Saved");
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}