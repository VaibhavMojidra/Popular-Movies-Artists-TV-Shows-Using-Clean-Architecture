package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow.TVShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TVShowList>
}