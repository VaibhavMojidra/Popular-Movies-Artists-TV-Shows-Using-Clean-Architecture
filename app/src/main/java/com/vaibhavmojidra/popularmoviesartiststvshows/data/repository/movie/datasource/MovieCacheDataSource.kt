package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasource

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}