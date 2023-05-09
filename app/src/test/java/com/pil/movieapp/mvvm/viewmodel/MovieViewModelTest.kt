package com.pil.movieapp.mvvm.viewmodel

import com.pil.movieapp.database.MovieDataBase
import com.pil.movieapp.service.MovieService
import com.pil.movieapp.service.model.Movie
import com.pil.movieapp.service.model.MovieList
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    var movieService: MovieService = mockk()
    var db: MovieDataBase = mockk()
    private val movies: List<Movie> = listOf(
        Movie(
            1,
            "title",
            "overview",
            "posterPath",
            5.0f,
            "path",
            "releaseDate",
            "Title",
            1.0f,
            1,
        ),
    )
    private lateinit var movieList: MovieList

    @Before
    fun setUp() {
        movieList = MovieList(movies, 1)
    }

    @Test
    fun `when getMovies is called, then return a list of movies`() {
        // Given
        // When
        // Then
    }
}
