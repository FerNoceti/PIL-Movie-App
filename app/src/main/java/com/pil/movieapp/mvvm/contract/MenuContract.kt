package com.pil.movieapp.mvvm.contract

import androidx.lifecycle.LiveData
import com.pil.movieapp.mvvm.viewmodel.MenuViewModel

interface MenuContract {
    interface ViewModel {

        fun getValue(): LiveData<MenuViewModel.MenuStates>
        fun buttonPressed()
        fun buttonErrorPressed()
    }
}
