package com.pil.movieapp.mvvm.contract

import android.content.Context

interface MenuContract {
    interface ViewModel {

        fun buttonPressed()
        fun buttonErrorPressed(context: Context)
    }
}
