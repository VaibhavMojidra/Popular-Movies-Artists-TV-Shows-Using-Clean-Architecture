package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasourceImpl

import com.vaibhavmojidra.popularmoviesartiststvshows.data.api.TMDBService
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.movie.MovieList
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmDBService: TMDBService,
    private val apiKey:String
    ): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmDBService.getPopularMovies(apiKey)
}