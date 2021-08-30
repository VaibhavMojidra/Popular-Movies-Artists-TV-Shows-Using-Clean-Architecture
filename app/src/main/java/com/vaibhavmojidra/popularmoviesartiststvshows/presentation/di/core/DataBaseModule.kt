package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao.ArtistDao
import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao.MovieDao
import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao.TVShowDao
import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.database.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideDataBase(context:Context):TMDBDatabase=Room.databaseBuilder(context,TMDBDatabase::class.java,"TMDB").build()

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao=tmdbDatabase.movieDao()

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase):ArtistDao=tmdbDatabase.artistDao()

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase):TVShowDao=tmdbDatabase.tvShowDao()
}