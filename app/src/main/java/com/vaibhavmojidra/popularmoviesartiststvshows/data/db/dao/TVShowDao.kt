package com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.tvshow.TVShow

@Dao
interface TVShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvShows:List<TVShow>)

    @Query("DELETE FROM TVSHOW")
    suspend fun deleteAllTVShows()

    @Query("SELECT * FROM TVSHOW")
    suspend fun getTVShows():List<TVShow>
}