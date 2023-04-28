package com.pil.movieapp.service

import android.graphics.pdf.PdfDocument.Page
import com.pil.movieapp.service.model.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieClient {
    // TODO: put api_key out
    @GET("movie/popular")
    fun getInitialData(): Call<MovieList>

    @GET("movie/popular")
    fun getDataWithAPage(@Query("page") page: Int): Call<MovieList>
}