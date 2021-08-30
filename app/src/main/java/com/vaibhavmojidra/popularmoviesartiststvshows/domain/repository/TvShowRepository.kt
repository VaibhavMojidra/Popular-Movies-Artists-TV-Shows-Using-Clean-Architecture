package com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository

import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow.TVShow

interface TvShowRepository {
    suspend fun getTvShows():List<TVShow>?
    suspend fun updateTvShows():List<TVShow>?
}