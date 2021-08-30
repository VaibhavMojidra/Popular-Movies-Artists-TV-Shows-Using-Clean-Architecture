package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.GetMoviesUseCase
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MovieViewModel(getMoviesUseCase,updateMoviesUseCase) as T

}