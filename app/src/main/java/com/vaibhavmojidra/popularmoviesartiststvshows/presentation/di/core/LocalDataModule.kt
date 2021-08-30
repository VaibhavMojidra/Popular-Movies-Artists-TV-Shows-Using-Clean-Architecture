package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.core

import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao.ArtistDao
import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao.MovieDao
import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao.TVShowDao
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource.ArtistLocalDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasource.MovieLocalDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieDataSource(movieDao:MovieDao):MovieLocalDataSource=MovieLocalDataSourceImpl(movieDao)

    @Singleton
    @Provides
    fun provideArtistDataSource(artistDao: ArtistDao):ArtistLocalDataSource=ArtistLocalDataSourceImpl(artistDao)

    @Singleton
    @Provides
    fun provideTvShowDataSource(tvShowDao: TVShowDao):TvShowLocalDataSource=TvShowLocalDataSourceImpl(tvShowDao)
}