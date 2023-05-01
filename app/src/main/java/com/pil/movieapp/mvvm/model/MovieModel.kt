package com.pil.movieapp.mvvm.model

import com.pil.movieapp.database.MovieDataBase
import com.pil.movieapp.mvvm.contract.MovieContract
import com.pil.movieapp.service.MovieService
import com.pil.movieapp.service.model.Movie
import com.pil.movieapp.util.CoroutineResult

class MovieModel(
    private val service: MovieService,
    private val database: MovieDataBase,
) : MovieContract.Model {
    override suspend fun getMovies(): CoroutineResult<List<Movie>> {
        return when (val movies = service.getMovies()) {
            is CoroutineResult.Success -> {
                database.insertMovies(movies.data.results)
                CoroutineResult.Success(database.getAllMovies())
            }

            is CoroutineResult.Failure -> {
                CoroutineResult.Success(database.getAllMovies())
            }
        }
    }
}
