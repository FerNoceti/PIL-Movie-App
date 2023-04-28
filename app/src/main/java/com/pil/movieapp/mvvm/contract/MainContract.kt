package com.pil.movieapp.mvvm.contract

import androidx.lifecycle.LiveData
import com.pil.movieapp.mvvm.viewmodel.MainViewModel
import com.pil.movieapp.service.model.Movie
import com.pil.movieapp.util.CoroutineResult
import kotlinx.coroutines.Job

interface MainContract {
    interface Model {
        suspend fun getMovies(page: Int? = null): CoroutineResult<List<Movie>>
    }

    interface ViewModel {
        fun getValue(): LiveData<MainViewModel.MainData>
        fun callService(): Job
    }
}