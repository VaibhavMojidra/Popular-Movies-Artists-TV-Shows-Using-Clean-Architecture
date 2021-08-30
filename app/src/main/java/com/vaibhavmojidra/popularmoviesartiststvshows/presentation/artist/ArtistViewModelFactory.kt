package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.GetArtistUseCase
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.UpdateArtistUseCase
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.UpdateMoviesUseCase

class ArtistViewModelFactory(private val getArtistUseCase: GetArtistUseCase, private val updateArtistUseCase: UpdateArtistUseCase) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T= ArtistViewModel(getArtistUseCase,updateArtistUseCase) as T
}