package com.pil.retrofit_room.service

import com.pil.movieapp.service.MovieClient
import com.pil.movieapp.service.model.MovieList
import com.pil.movieapp.util.CoroutineResult

interface MovieService {
    suspend fun getExercises(): CoroutineResult<MovieList>
}

class MovieServiceImpl(private val client: MovieClient) : MovieService {

    override suspend fun getExercises(): CoroutineResult<MovieList> {
        try {
            val response = client.getInitialData().execute()
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
