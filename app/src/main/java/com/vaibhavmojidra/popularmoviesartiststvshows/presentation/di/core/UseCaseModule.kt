package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.core

import com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository.ArtistRepository
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository.MovieRepository
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository.TvShowRepository
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository):GetMoviesUseCase= GetMoviesUseCase(movieRepository)

    @Singleton
    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase=UpdateMoviesUseCase(movieRepository)

    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistUseCase=GetArtistUseCase(artistRepository)

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistUseCase=UpdateArtistUseCase(artistRepository)

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowUseCase=GetTvShowUseCase(tvShowRepository)

    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository):UpdateTvShowUseCase=
        UpdateTvShowUseCase(tvShowRepository)
}