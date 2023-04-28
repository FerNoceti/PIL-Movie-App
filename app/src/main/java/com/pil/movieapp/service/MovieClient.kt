package com.pil.movieapp.service

import com.pil.movieapp.service.model.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieClient {
    @GET("movie/popular")
    fun getData(@Query("page") page: Int? = null): Call<MovieList>
}