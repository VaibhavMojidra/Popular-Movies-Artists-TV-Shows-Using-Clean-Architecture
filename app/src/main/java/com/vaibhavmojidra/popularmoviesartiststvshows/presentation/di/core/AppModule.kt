package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.core

import android.content.Context
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.artist.ArtistSubComponent
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.movie.MovieSubComponent
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,ArtistSubComponent::class,TvShowSubComponent::class])
class AppModule(private val context:Context) {
    @Singleton
    @Provides
    fun provideApplicationContext():Context=context.applicationContext
}