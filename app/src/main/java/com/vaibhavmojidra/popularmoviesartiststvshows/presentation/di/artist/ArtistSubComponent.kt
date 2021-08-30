package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.artist

import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}