package com.pil.movieapp.database.mapper

import com.pil.movieapp.database.entity.MovieEntity
import com.pil.movieapp.service.model.Movie

fun Movie.mapToDataBaseMovie(): MovieEntity =
    MovieEntity(
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount,
    )

fun List<MovieEntity>.mapToLocalMovie(): List<Movie> =
    map { entity ->
        Movie(
            id = entity.id,
            originalLanguage = entity.originalLanguage,
            originalTitle = entity.originalTitle,
            overview = entity.overview,
            popularity = entity.popularity,
            posterPath = entity.posterPath,
            releaseDate = entity.releaseDate,
            title = entity.title,
            voteAverage = entity.voteAverage,
            voteCount = entity.voteCount,

        )
    }
