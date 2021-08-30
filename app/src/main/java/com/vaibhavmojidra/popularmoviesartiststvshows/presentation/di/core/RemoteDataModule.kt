package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.core

import com.vaibhavmojidra.popularmoviesartiststvshows.data.api.TMDBService
import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.database.TMDBDatabase
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource.ArtistRemoteDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasource.MovieRemoteDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource=MovieRemoteDataSourceImpl(tmdbService,apiKey)

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSource=ArtistRemoteDataSourceImpl(tmdbService,apiKey)

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService):TvShowRemoteDataSource=TvShowRemoteDataSourceImpl(tmdbService,apiKey)


}