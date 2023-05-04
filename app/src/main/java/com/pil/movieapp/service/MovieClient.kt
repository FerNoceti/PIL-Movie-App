package com.pil.movieapp.service

import com.pil.movieapp.service.model.MovieList
import retrofit2.Call
import retrofit2.http.GET

interface MovieClient {
    @GET("movie/popular")
    fun getData(): Call<MovieList>
}
