package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository

import android.util.Log
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow.TVShow
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {
    override suspend fun getTvShows(): List<TVShow>? =getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TVShow>? {
        val newTvShowsList=getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTVShowsToDB(newTvShowsList)
        tvShowCacheDataSource.saveTvShowsToCache(newTvShowsList)
        return newTvShowsList
    }

    private suspend fun getTvShowsFromAPI():List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try {
            val response=tvShowRemoteDataSource.getTvShows()
            val body=response.body()
            if(body!=null){
                tvShowList=body.tvShows
            }
        }catch (ex: Exception){
            Log.i("MyInfo",ex.message.toString())
        }
        return tvShowList
    }

    private suspend fun getTvShowsFromDB():List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList=tvShowLocalDataSource.getTVShowsFromDB()
            if(tvShowList.isNotEmpty()){
                return  tvShowList
            }else{
                tvShowList=getTvShowsFromAPI()
                tvShowLocalDataSource.saveTVShowsToDB(tvShowList)
                return tvShowList
            }
        }catch (ex:Exception){
            Log.i("MyInfo",ex.message.toString())
        }
        return tvShowList
    }

    private suspend fun getTvShowsFromCache():List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList=tvShowCacheDataSource.getTvShowsFromCache()
            if(tvShowList.isNotEmpty()){
                return  tvShowList
            }else{
                tvShowList=getTvShowsFromDB()
                tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
                return tvShowList
            }
        }catch (ex:Exception){
            Log.i("MyInfo",ex.message.toString())
        }
        return tvShowList
    }
}