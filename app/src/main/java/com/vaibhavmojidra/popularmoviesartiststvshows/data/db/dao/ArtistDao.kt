package com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists:List<Artist>)

    @Query("DELETE FROM ARTIST")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM ARTIST")
    suspend fun getArtists():List<Artist>
}