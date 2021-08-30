package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}