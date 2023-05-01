package com.pil.movieapp.service

import com.pil.movieapp.service.model.MovieList
import com.pil.movieapp.util.CoroutineResult

interface MovieService {
    suspend fun getMovies(): CoroutineResult<MovieList>
}

class MovieServiceImpl(private val client: MovieClient) : MovieService {

    override suspend fun getMovies(): CoroutineResult<MovieList> {
        try {
            val response = client.getData().execute()
            if (response.isSuccessful) {
                response.body()?.let {
                    return CoroutineResult.Success(it)
                }
            }
            return CoroutineResult.Failure(Exception(response.errorBody().toString()))
        } catch (e: Exception) {
            return CoroutineResult.Failure(e)
        }
    }
}
