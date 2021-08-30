package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasourceImpl

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.artist.Artist
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl:ArtistCacheDataSource {
    private var artistList=ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> = artistList

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList=ArrayList(artists)
    }
}