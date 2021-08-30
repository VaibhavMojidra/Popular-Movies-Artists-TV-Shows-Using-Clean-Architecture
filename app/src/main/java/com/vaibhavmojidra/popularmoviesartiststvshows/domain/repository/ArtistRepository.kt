package com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>
    suspend fun updateArtists():List<Artist>
}