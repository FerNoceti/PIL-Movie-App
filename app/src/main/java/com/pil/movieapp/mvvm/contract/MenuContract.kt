package com.pil.movieapp.mvvm.contract

interface MenuContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
    }

    interface ViewModel {

        fun buttonPressed()
    }
}
