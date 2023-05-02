package com.pil.movieapp.mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.pil.movieapp.mvvm.contract.MenuContract
import com.pil.movieapp.mvvm.viewmodel.MenuViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MenuViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MenuContract.ViewModel

    @Before
    fun setUp(){
        viewModel = MenuViewModel()
    }
}