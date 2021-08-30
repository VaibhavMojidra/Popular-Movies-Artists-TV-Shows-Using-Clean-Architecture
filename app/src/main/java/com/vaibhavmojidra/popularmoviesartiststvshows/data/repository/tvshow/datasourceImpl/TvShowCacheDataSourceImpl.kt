package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasourceImpl


import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow.TVShow
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl:TvShowCacheDataSource {
    private var tvShowList=ArrayList<TVShow>()
    override suspend fun getTvShowsFromCache(): List<TVShow> = tvShowList

    override suspend fun saveTvShowsToCache(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList= ArrayList(tvShows)
    }
}