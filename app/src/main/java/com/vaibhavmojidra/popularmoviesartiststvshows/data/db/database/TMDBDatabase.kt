package com.vaibhavmojidra.popularmoviesartiststvshows.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao.ArtistDao
import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao.MovieDao
import com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao.TVShowDao
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.artist.Artist
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.movie.Movie
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow.TVShow

@Database(entities = [Movie::class,TVShow::class,Artist::class],version = 1,exportSchema = false)
abstract class TMDBDatabase: RoomDatabase(){
    abstract fun movieDao():MovieDao
    abstract fun tvShowDao():TVShowDao
    abstract fun artistDao():ArtistDao
}