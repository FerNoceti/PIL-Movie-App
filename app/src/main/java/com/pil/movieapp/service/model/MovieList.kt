package com.pil.movieapp.service.model

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    var results: List<Movie>,
)
