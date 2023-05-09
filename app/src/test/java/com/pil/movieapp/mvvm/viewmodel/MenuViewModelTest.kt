package com.pil.movieapp.mvvm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MenuViewModelTest {

    private lateinit var menuViewModel: MenuViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        menuViewModel = MenuViewModel()
    }

    @Test
    fun `init state`() {
        assert(menuViewModel.getValue().value == MenuViewModel.MenuStates.INIT)
    }

    @Test
    fun `set livedata with GO_TO_MOVIE_SCREEN as value`() {
        menuViewModel.buttonPressed()
        assert(menuViewModel.getValue().value == MenuViewModel.MenuStates.GO_TO_MOVIE_SCREEN)
    }

    @Test
    fun `set livedata with ERROR as value`() {
        menuViewModel.buttonErrorPressed()
        assert(menuViewModel.getValue().value == MenuViewModel.MenuStates.ERROR)
    }
}
