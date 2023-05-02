package com.pil.movieapp.mvvm.contract

import androidx.lifecycle.LiveData
import com.pil.movieapp.mvvm.viewmodel.MovieViewModel
import com.pil.movieapp.service.model.Movie
import com.pil.movieapp.util.CoroutineResult
import kotlinx.coroutines.Job

interface MovieContract {
    interface Model {
        suspend fun getMovies(): CoroutineResult<List<Movie>>
    }

    interface ViewModel {
        fun getValue(): LiveData<MovieViewModel.MainData>
        fun callService(): Job
        fun goBack()
    }
}
