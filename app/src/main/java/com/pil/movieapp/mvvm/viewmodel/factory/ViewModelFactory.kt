package com.pil.movieapp.mvvm.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pil.movieapp.mvvm.contract.MovieContract
import com.pil.movieapp.mvvm.viewmodel.MovieViewModel

class ViewModelFactory(private val params: Array<Any>) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MovieViewModel::class.java -> MovieViewModel(params[0] as MovieContract.Model) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
