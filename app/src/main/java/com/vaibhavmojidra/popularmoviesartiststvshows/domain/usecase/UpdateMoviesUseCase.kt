package com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.movie.Movie
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository.MovieRepository

class UpdateMoviesUseCase (private val movieRepository: MovieRepository){
    suspend fun execute():List<Movie>?=movieRepository.updateMovies()
}