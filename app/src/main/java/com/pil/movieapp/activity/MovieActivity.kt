package com.pil.movieapp.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.pil.movieapp.adapter.MovieAdapter
import com.pil.movieapp.database.MovieDataBaseImplementation
import com.pil.movieapp.database.MoviesRoomDataBase
import com.pil.movieapp.databinding.ActivityMovieBinding
import com.pil.movieapp.mvvm.contract.MovieContract
import com.pil.movieapp.mvvm.model.MovieModel
import com.pil.movieapp.mvvm.viewmodel.MovieViewModel
import com.pil.movieapp.mvvm.viewmodel.factory.ViewModelFactory
import com.pil.movieapp.service.MovieClient
import com.pil.movieapp.service.MovieRequestGenerator
import com.pil.movieapp.service.MovieServiceImpl

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding
    private lateinit var viewModel: MovieContract.ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataBase: MoviesRoomDataBase by lazy {
            Room
                .databaseBuilder(this, MoviesRoomDataBase::class.java, "Movie-DataBase")
                .build()
        }

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                arrayOf(
                    MovieModel(
                        MovieServiceImpl(MovieRequestGenerator.createService(MovieClient::class.java)),
                        MovieDataBaseImplementation(dataBase.movieDao()),
                    ),
                ),
            ),
        )[MovieViewModel::class.java]

        viewModel.getValue().observe(this) { updateUI(it) }

        binding.buttonBack.setOnClickListener { viewModel.goBack() }
    }

    override fun onResume() {
        super.onResume()
        viewModel.callService()
    }

    private fun updateUI(data: MovieViewModel.MainData) {
        when (data.status) {
            MovieViewModel.MainStatus.SHOW_INFO -> {
                binding.recycler.adapter = MovieAdapter(data.movies)
                binding.recycler.layoutManager = LinearLayoutManager(this)
            }
            MovieViewModel.MainStatus.EMPTY -> {
                binding.recycler.visibility = View.GONE
                binding.empty.visibility = View.VISIBLE
            }
            MovieViewModel.MainStatus.GO_BACK -> {
                finish()
            }
        }
    }
}
