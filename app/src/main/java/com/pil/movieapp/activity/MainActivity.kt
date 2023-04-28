package com.pil.movieapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.pil.movieapp.adapter.MovieAdapter
import com.pil.movieapp.database.MovieDataBaseImplementation
import com.pil.movieapp.database.MoviesRoomDataBase
import com.pil.movieapp.databinding.ActivityMainBinding
import com.pil.movieapp.mvvm.contract.MainContract
import com.pil.movieapp.mvvm.model.MainModel
import com.pil.movieapp.mvvm.viewmodel.MainViewModel
import com.pil.movieapp.mvvm.viewmodel.factory.ViewModelFactory
import com.pil.movieapp.service.MovieClient
import com.pil.movieapp.service.MovieRequestGenerator
import com.pil.movieapp.service.MovieServiceImpl

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainContract.ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
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
                    MainModel(
                        MovieServiceImpl(MovieRequestGenerator.createService(MovieClient::class.java)),
                        MovieDataBaseImplementation(dataBase.movieDao()),
                    ),
                ),
            ),
        )[MainViewModel::class.java]

        viewModel.getValue().observe(this) { updateUI(it) }

        binding.button.setOnClickListener { viewModel.callService() }
        binding.buttonClear.setOnClickListener { viewModel.clear() }
        binding.buttonPage.setOnClickListener { viewModel.callService(getPage()) }
    }

    private fun updateUI(data: MainViewModel.MainData) {
        when (data.status) {
            MainViewModel.MainStatus.INITIAL -> {
                binding.recycler.adapter = null
                binding.recycler.layoutManager = null
            }
            MainViewModel.MainStatus.SHOW_INFO -> {
                binding.recycler.layoutManager = LinearLayoutManager(this)
                binding.recycler.adapter = MovieAdapter(data.movies)
            }
            MainViewModel.MainStatus.ERROR -> {
                binding.recycler.adapter = null
                binding.recycler.layoutManager = null
            }
        }
    }

    private fun getPage(): Int {
        val page = binding.pageSelector.text.toString().toIntOrNull()
        return if (page != null && page in 1..50) page else 1
    }
}
