package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.core

import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource.ArtistCacheDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasource.MovieCacheDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource=MovieCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource=ArtistCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCacheDataSource=TvShowCacheDataSourceImpl()
}