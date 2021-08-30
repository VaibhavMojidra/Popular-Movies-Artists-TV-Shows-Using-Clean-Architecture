package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasourceImpl

import com.vaibhavmojidra.popularmoviesartiststvshows.data.api.TMDBService
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow.TVShowList
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmDBService: TMDBService,
    private val apiKey:String
):TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TVShowList> = tmDBService.getPopularTVShows(apiKey)
}