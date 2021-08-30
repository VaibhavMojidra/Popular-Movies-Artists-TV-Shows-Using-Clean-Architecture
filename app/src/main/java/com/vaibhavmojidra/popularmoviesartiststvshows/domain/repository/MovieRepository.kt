package com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}