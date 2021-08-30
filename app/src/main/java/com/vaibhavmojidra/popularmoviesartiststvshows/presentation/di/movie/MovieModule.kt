package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.movie

import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.GetMoviesUseCase
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.UpdateMoviesUseCase
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase,updateMoviesUseCase: UpdateMoviesUseCase):MovieViewModelFactory=MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
}