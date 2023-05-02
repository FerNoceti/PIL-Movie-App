package com.pil.movieapp.database

import com.pil.movieapp.database.dao.MovieDao
import com.pil.movieapp.database.mapper.mapToDataBaseMovie
import com.pil.movieapp.database.mapper.mapToLocalMovie
import com.pil.movieapp.service.model.Movie

interface MovieDataBase {
    suspend fun insertMovies(movies: List<Movie>)
    suspend fun getAllMovies(): List<Movie>
}

class MovieDataBaseImplementation(private val movieDao: MovieDao) : MovieDataBase {
    override suspend fun insertMovies(movies: List<Movie>) {
        movies.forEach {
            movieDao.insertMovie(it.mapToDataBaseMovie())
        }
    }

    override suspend fun getAllMovies(): List<Movie> {
        return movieDao.getDBMovies().mapToLocalMovie()
    }
}
