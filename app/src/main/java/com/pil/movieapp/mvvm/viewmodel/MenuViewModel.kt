package com.pil.movieapp.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pil.movieapp.mvvm.contract.MenuContract

class MenuViewModel : ViewModel(), MenuContract.ViewModel {

    private val _state = MutableLiveData<MenuStates>()
    val state: LiveData<MenuStates>
        get() = _state

    override fun buttonPressed() {
        _state.value = MenuStates.GO_TO_MOVIE_SCREEN
    }

    init {
        _state.value = MenuStates.INIT
    }

    enum class MenuStates {
        INIT,
        GO_TO_MOVIE_SCREEN,
    }
}
