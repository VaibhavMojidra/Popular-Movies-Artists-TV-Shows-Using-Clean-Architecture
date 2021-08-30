package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.di.artist

import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.GetArtistUseCase
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.UpdateArtistUseCase
import com.vaibhavmojidra.popularmoviesartiststvshows.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(getArtistUseCase: GetArtistUseCase,updateArtistUseCase: UpdateArtistUseCase)
    :ArtistViewModelFactory=ArtistViewModelFactory(getArtistUseCase,updateArtistUseCase)
}