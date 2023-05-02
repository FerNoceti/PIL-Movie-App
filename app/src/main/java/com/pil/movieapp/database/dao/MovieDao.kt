package com.pil.movieapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pil.movieapp.database.entity.MovieEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(binEntity: MovieEntity): Long

    @Query("SELECT * FROM movie")
    fun getDBMovies(): List<MovieEntity>
}
