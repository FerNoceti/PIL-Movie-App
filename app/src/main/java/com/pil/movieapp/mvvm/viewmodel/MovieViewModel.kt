package com.pil.movieapp.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pil.movieapp.mvvm.contract.MovieContract
import com.pil.movieapp.service.model.Movie
import com.pil.movieapp.util.CoroutineResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel(private val model: MovieContract.Model) :
    ViewModel(),
    MovieContract.ViewModel {

    private val mutableLiveData: MutableLiveData<MainData> = MutableLiveData()
    override fun getValue(): LiveData<MainData> = mutableLiveData

    override fun callService(): Job {
        return viewModelScope.launch {
            withContext(Dispatchers.IO) { model.getMovies() }.let { result ->
                when (result) {
                    is CoroutineResult.Success -> {
                        if (result.data.isEmpty()) {
                            mutableLiveData.value = MainData(MainStatus.EMPTY, emptyList())
                        } else {
                            mutableLiveData.value = MainData(MainStatus.SHOW_INFO, result.data)
                        }
                    }
                    is CoroutineResult.Failure -> {
                    }
                }
            }
        }
    }

    override fun goBack() {
        mutableLiveData.value = MainData(MainStatus.GO_BACK, emptyList())
    }

    data class MainData(
        val status: MainStatus,
        val movies: List<Movie>,
    )

    enum class MainStatus {
        SHOW_INFO,
        EMPTY,
        GO_BACK,
    }
}
