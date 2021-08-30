package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasource

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}