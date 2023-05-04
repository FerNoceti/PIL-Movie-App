package com.pil.movieapp.mvvm.viewmodel

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pil.movieapp.R
import com.pil.movieapp.mvvm.contract.MenuContract
import com.pil.movieapp.util.ErrorDialog

class MenuViewModel : ViewModel(), MenuContract.ViewModel {

    private val _state = MutableLiveData<MenuStates>()
    val state: LiveData<MenuStates>
        get() = _state

    override fun buttonPressed() {
        _state.value = MenuStates.GO_TO_MOVIE_SCREEN
    }

    override fun buttonErrorPressed(context: Context) {
        ErrorDialog.show(
            context,
            context.getString(R.string.error_title),
            context.getString(R.string.error_description)
        )
    }

    init {
        _state.value = MenuStates.INIT
    }

    enum class MenuStates {
        INIT,
        GO_TO_MOVIE_SCREEN,
    }
}
