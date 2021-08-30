package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasourceImpl

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.movie.Movie
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList=ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> = movieList

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList= ArrayList(movies)
    }
}