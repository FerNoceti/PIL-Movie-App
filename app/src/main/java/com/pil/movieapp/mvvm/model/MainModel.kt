package com.pil.movieapp.mvvm.model

import com.pil.movieapp.database.MovieDataBase
import com.pil.movieapp.mvvm.contract.MainContract
import com.pil.movieapp.service.model.Movie
import com.pil.movieapp.util.CoroutineResult
import com.pil.retrofit_room.service.MovieService

class MainModel(
    private val service: MovieService,
    private val database: MovieDataBase,
    ) : MainContract.Model {

    override suspend fun getMovies(): CoroutineResult<List<Movie>> {
        return when (val movies = service.getExercises()) {
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