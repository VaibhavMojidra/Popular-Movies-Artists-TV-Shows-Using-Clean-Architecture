package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.tvshow

import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}