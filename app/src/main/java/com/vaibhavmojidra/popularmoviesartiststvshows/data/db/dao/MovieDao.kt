package com.vaibhavmojidra.popularmoviesartiststvshows.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vaibhavmojidra.popularmoviesartiststvshows.data.model.movie.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies:List<Movie>)

    @Query("DELETE FROM MOVIE")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM MOVIE")
    suspend fun getMovies():List<Movie>
}