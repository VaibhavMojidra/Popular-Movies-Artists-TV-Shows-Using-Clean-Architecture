package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow.TVShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TVShow>
    suspend fun saveTvShowsToCache(movies:List<TVShow>)
}