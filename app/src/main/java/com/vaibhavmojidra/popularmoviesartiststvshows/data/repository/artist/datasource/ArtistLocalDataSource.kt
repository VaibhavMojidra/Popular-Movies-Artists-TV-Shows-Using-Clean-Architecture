package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists:List<Artist>)
    suspend fun clearAll()
}