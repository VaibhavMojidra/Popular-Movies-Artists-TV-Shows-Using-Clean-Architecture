package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di

import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.artist.ArtistSubComponent
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.movie.MovieSubComponent
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
}