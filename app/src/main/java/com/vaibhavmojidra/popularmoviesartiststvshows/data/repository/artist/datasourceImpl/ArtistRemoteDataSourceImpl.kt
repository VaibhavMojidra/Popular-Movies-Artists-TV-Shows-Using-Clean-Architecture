package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasourceImpl

import com.vaibhavmojidra.popularmoviesartiststvshows.data.api.TMDBService
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.artist.ArtistList
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmDBService: TMDBService, private val apiKey:String):ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmDBService.getPopularArtists(apiKey)
}