package com.pil.movieapp.mvvm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.pil.movieapp.database.MovieDataBase
import com.pil.movieapp.mvvm.contract.MenuContract
import com.pil.movieapp.mvvm.contract.MovieContract
import com.pil.movieapp.mvvm.model.MovieModel
import com.pil.movieapp.mvvm.viewmodel.MenuViewModel
import com.pil.movieapp.mvvm.viewmodel.MovieViewModel
import com.pil.movieapp.service.MovieService
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MovieViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieContract.ViewModel

    @Before
    fun setUp(){
    }
}