package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.movie

import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.tvshow.TvShowScope
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():MovieSubComponent
    }
}