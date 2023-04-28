package com.pil.movieapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pil.movieapp.database.dao.MovieDao
import com.pil.movieapp.database.entity.MovieEntity

@Database(
    entities = [
        MovieEntity::class,
    ],
    version = 1,
)

abstract class MoviesRoomDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}