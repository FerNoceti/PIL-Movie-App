package com.pil.movieapp.service

import com.pil.movieapp.service.model.MovieList
import retrofit2.Call
import retrofit2.http.GET

interface MovieClient {
    // TODO: put api_key out
    @GET("movie/popular?api_key=9bafc3601544aaecd7821f666201d894")
    fun getData(): Call<MovieList>
}