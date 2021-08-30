package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasourceImpl

import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao.TVShowDao
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow.TVShow
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TVShowDao):TvShowLocalDataSource {
    override suspend fun getTVShowsFromDB(): List<TVShow> =tvShowDao.getTVShows()

    override suspend fun saveTVShowsToDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTVShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTVShows()
        }
    }
}