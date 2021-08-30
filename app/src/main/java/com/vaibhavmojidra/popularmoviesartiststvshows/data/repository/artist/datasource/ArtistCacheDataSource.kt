package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}