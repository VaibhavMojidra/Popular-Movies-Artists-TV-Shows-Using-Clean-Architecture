package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.core

import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.ArtistRepositoryImpl
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.MovieRepositoryImpl
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.TvShowRepositoryImpl
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource.ArtistCacheDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource.ArtistLocalDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource.ArtistRemoteDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasource.MovieCacheDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasource.MovieLocalDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasource.MovieRemoteDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository.ArtistRepository
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository.MovieRepository
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ):MovieRepository
    =MovieRepositoryImpl(movieRemoteDataSource,movieLocalDataSource,movieCacheDataSource)

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ):ArtistRepository=ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ):TvShowRepository=TvShowRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
}