package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow.TVShow

interface TvShowLocalDataSource {
    suspend fun getTVShowsFromDB():List<TVShow>
    suspend fun saveTVShowsToDB(tvShows:List<TVShow>)
    suspend fun clearAll()
}