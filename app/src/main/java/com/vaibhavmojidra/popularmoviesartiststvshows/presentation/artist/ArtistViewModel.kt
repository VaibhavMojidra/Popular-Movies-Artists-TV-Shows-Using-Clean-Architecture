package com.vaibhavmojidra.popularmoviesartiststvshows.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.GetArtistUseCase
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(private val getArtistUseCase: GetArtistUseCase,private val updateArtistUseCase: UpdateArtistUseCase):ViewModel() {
    fun getArtists()= liveData {
        val artistList=getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtists()= liveData {
        val artistList=updateArtistUseCase.execute()
        emit(artistList)
    }
}