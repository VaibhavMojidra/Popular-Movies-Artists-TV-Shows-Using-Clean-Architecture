package com.vaibhavmojidra.popularmoviesartiststvshows.data.repository

import android.util.Log
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.artist.Artist
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource.ArtistCacheDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource.ArtistLocalDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.data.repository.artist.datasource.ArtistRemoteDataSource
import com.vaibhavmojidra.popularmoviesartiststvshows.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl
    (
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
    ):ArtistRepository {
    override suspend fun getArtists(): List<Artist> =getArtistFromCache()

    override suspend fun updateArtists(): List<Artist> {
       val newArtistList=getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newArtistList)
        artistCacheDataSource.saveArtistsToCache(newArtistList)
        return newArtistList
    }

    private suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response=artistRemoteDataSource.getArtists()
            val body=response.body()
            if(body!=null){
                artistList=body.artists
            }
        }catch (ex: Exception){
            Log.i("MyInfo",ex.message.toString())
        }
        return artistList
    }

    private suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList=artistLocalDataSource.getArtistsFromDB()
            if(artistList.isNotEmpty()){
                return artistList
            }else{
                artistList=getArtistsFromAPI()
                artistLocalDataSource.saveArtistsToDB(artistList)
                return artistList
            }
        }catch (ex: Exception){
            Log.i("MyInfo",ex.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromCache():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList=artistCacheDataSource.getArtistsFromCache()
            if(artistList.isNotEmpty()){
                return artistList
            }else{
                artistList=getArtistsFromDB()
                artistCacheDataSource.saveArtistsToCache(artistList)
                return artistList
            }
        }catch (ex: Exception){
            Log.i("MyInfo",ex.message.toString())
        }
        return artistList
    }
}