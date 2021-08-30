package com.vaibhavmojidra.popularmoviesartiststvshows.domain.usecase

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.artist.Artist
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>?=artistRepository.getArtists()
}