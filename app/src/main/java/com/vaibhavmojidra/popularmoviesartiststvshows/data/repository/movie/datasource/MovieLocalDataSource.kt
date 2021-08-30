package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasource

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}